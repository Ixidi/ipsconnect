package pl.ixidi.ipsconnect.request.impl;

import com.squareup.moshi.JsonAdapter;
import pl.ixidi.ipsconnect.request.Request;

public abstract class IpsRequest implements Request {

    private String doName;
    private JsonAdapter adapter;

    public IpsRequest(String doName, Class bodyClass) {
        this.doName = doName;
        this.adapter = MOSHI.adapter(bodyClass);
    }

    public final String getDoName() {
        return doName;
    }

    public final JsonAdapter getAdapter() {
        return adapter;
    }

    @Override
    public String modifyKey(String key) {
        return key;
    }
}
