package pl.ixidi.ipsconnect;

import com.squareup.moshi.JsonAdapter;
import pl.ixidi.ipsconnect.request.Request;
import pl.ixidi.ipsconnect.responce.Response;
import pl.ixidi.ipsconnect.responce.ResponseStatus;
import pl.ixidi.ipsconnect.responce.impl.IpsResponse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Executors;

public class IpsConnect {

    private String url;
    private String key;
    private final JsonAdapter<JsonStatus> adapter = Request.MOSHI.adapter(JsonStatus.class);

    public IpsConnect(String url, String key) {
        this.url = url;
        this.key = key;
    }

    public void asyncRequest(Request request, PostRequest postRequest) {
        Executors.newSingleThreadExecutor().execute(() -> {
            Response response = request(request);
            if (response.getStatus() == ResponseStatus.SUCCESS) {
                postRequest.success(response);
            } else {
                postRequest.error(response.getStatus());
            }
        });
    }

    public Response request(Request request) {
        try {
            URL url = new URL(this.url + "?key=" + request.modifyKey(key) + "&do=" + request.getDoName() + request.getQuery());
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
            int code = connection.getResponseCode();
            if (code != 200)
                throw new IOException("Api returned " + code + " " + connection.getResponseMessage());
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            connection.disconnect();

            String jsonBody = builder.toString();
            JsonStatus jsonStatus = adapter.fromJson(jsonBody);
            if (jsonStatus == null) {
                return new IpsResponse(ResponseStatus.LIBRARY_ERROR, null);
            }
            ResponseStatus status = ResponseStatus.matchStatus(jsonStatus.getStatus());
            if (status == ResponseStatus.SUCCESS) {
                return new IpsResponse(status, request.getAdapter().fromJson(jsonBody));
            } else {
                return new IpsResponse(status, null);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return new IpsResponse(ResponseStatus.API_ERROR, null);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
