package pl.ixidi.ipsconnect.responce.body;

import com.squareup.moshi.Json;

public class FetchSaltBody {

    @Json(name = "pass_salt")
    private String salt;

    public String getSalt() {
        return salt;
    }
}
