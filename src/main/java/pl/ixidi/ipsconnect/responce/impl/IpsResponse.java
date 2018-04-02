package pl.ixidi.ipsconnect.responce.impl;

import pl.ixidi.ipsconnect.responce.Response;
import pl.ixidi.ipsconnect.responce.ResponseStatus;

public class IpsResponse implements Response {

    private ResponseStatus status;
    private Object body;

    public IpsResponse(ResponseStatus status, Object body) {
        this.status = status;
        this.body = body;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public Object getBody() {
        return body;
    }

}
