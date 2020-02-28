package unionfind;

public class SSS {
    int key;
    int value;

    public SSS(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public static void sta() {
        sta();
    }

    public static void main(String[] args) {
        String a = "123123aa";
//        a.intern();
//        String b = "123123aa";
        String b = new String("123123aa");
//        String b = new String("123");
        System.out.println(a == b);
        String myStr = "aa" + "bb" + "cc" + "dd";

    }


}
