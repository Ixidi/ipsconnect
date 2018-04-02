package pl.ixidi.ipsconnect;

public enum IdType {

    DISPLAY_NAME(1),
    EMAIL(2),
    BOTH(3);

    private int value;

    IdType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}