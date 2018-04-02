package pl.ixidi.ipsconnect.request.impl;

import pl.ixidi.ipsconnect.responce.body.CheckEmailBody;

public class CheckEmailRequest extends IpsRequest {

    private String email;

    public CheckEmailRequest(String email) {
        super("checkEmail", CheckEmailBody.class);
        this.email = email;
    }

    @Override
    public String getQuery() {
        return "&email=" + email;
    }

}
