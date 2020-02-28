package test;

public final class FinalUser {
    public String name;

    public FinalUser(String name) {
        this.name = name;
    }

    public final int aaa() {
        return 1;
    }
}
