package pl.ixidi.ipsconnect.responce;

import java.util.Arrays;

public enum ResponseStatus {

    LIBRARY_ERROR,
    UNSUPPORTED_STATUS,
    API_ERROR,
    SUCCESS,
    WRONG_AUTH,
    REQUEST_MISSING_DATA,
    ACCOUNT_NOT_FOUND,
    BAD_KEY,
    INVALID_ACTION;

    public static ResponseStatus matchStatus(String name) {
        String toMatch = name.replace(" ", "_").toUpperCase();
        return Arrays.stream(ResponseStatus.values())
                .filter(responseStatus -> responseStatus.name().equals(toMatch))
                .findAny()
                .orElse(UNSUPPORTED_STATUS);
    }
}
