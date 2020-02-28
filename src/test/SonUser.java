package test;

public class SonUser extends User {
    public SonUser(String name) {
        super(name);
    }

    int i;

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public static void io() {
        Interfa.ad();
    }
}
