package pl.ixidi.ipsconnect.request.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.ixidi.ipsconnect.IdType;
import pl.ixidi.ipsconnect.responce.body.LoginBody;
import pl.ixidi.ipsconnect.utils.HashUtils;

public class LoginRequest extends IpsRequest {

    private IdType idType;
    private String id;
    private String password;
    private String salt;

    public LoginRequest(IdType idType, String id, String password, String salt) {
        super("login", LoginBody.class);
        this.idType = idType;
        this.id = id;
        this.password = password;
        this.salt = salt;
    }

    @Override
    public String getQuery() {
        return "&idType=" + idType.getValue() + "&id=" + id + "&password=" + HashUtils.password(password, salt);
    }

    @Override
    public String modifyKey(String key) {
        return DigestUtils.md5Hex(key + id);
    }
}
