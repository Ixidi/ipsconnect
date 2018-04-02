package pl.ixidi.ipsconnect.responce.body;

import com.squareup.moshi.Json;

public class LoginBody {

    private String validating;
    private String email;
    private String name;
    @Json(name = "connect_id")
    private String id;
    @Json(name = "connect_revalidate_url")
    private String revalidateUrl;

    public boolean isValidating() {
        return validating.equals("VALIDATING");
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Integer.parseInt(id);
    }

    public String getRevalidateUrl() {
        return revalidateUrl;
    }
}
