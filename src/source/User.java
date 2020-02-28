package source;

public class User {
    public String name;

    static {
        System.out.println("userTTT");
    }

    public void usersout() {
    }

//    public static int usersout(ArrayList<Integer> list) {
//        return 1;
//    }
//
//    public static String usersout(ArrayList<String> list) {
//        return "";
//    }

    public static void main(String[] args) {
        User user = new User();
//        int c = TestDemo.c;
        new TestDemo().test01();
    }
}
