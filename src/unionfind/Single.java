package unionfind;

public enum Single {
    SI("1212", 1);

    String key;
    int value;

    Single(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
