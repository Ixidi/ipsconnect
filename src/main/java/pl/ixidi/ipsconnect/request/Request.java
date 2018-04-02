package pl.ixidi.ipsconnect.request;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

public interface Request {

    Moshi MOSHI = new Moshi.Builder().build();

    String getDoName();

    String getQuery();

    JsonAdapter getAdapter();

    String modifyKey(String key);

}
