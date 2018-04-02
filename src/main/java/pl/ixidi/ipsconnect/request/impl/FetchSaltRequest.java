package pl.ixidi.ipsconnect.request.impl;

import org.apache.commons.codec.digest.DigestUtils;
import pl.ixidi.ipsconnect.IdType;
import pl.ixidi.ipsconnect.responce.body.FetchSaltBody;

public class FetchSaltRequest extends IpsRequest {

    private IdType idType;
    private String id;

    public FetchSaltRequest(IdType idType, String id) {
        super("fetchSalt", FetchSaltBody.class);
        this.idType = idType;
        this.id = id;
    }

    public String getQuery() {
        return "&idType=" + idType.getValue() + "&id=" + id;
    }

    @Override
    public String modifyKey(String key) {
        return DigestUtils.md5Hex(key + id);
    }
}
