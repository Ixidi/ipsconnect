package pl.ixidi.ipsconnect.responce;

public interface Response {

    ResponseStatus getStatus();

    Object getBody();

}
