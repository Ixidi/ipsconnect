package pl.ixidi.ipsconnect;

import pl.ixidi.ipsconnect.responce.Response;
import pl.ixidi.ipsconnect.responce.ResponseStatus;

public interface PostRequest {

    void success(Response response);

    void error(ResponseStatus status);

}
