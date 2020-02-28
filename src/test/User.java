package test;

import java.util.HashMap;

public class User<T> {
    public String name;
    T[] as;
    public int a;
    public int b;

    public User(String name) {
        as = (T[]) new Object[123];
        this.name = name;
        Integer[] a = new Integer[]{1, 2, 3};
    }

    void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        /*
            10000000
            01111111
         */
        int q = 128;
        byte b = (byte) q;
        System.out.println(b);
        int x = 0xFFFFFFFF;
        System.out.println(x);
        System.out.println(++x);
        try {
            Class.forName("adad");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FinalUser finalUser = new FinalUser("12");
        finalUser = new FinalUser("1212");
        String str2 = "ab";  //1个对象
        String str3 = "cd";  //1个对象
        String str4 = str2 + str3;
        String str5 = "abcd";
        System.out.println("str4 = str5 : " + (str4 == str5)); // false
        User user = new User("12");
        User user1 = new User("13");
//        try {
//            user.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
        HashMap<User, Integer> map = new HashMap<>();
        map.put(user, 1);
        map.put(user, 11);
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(map.get(user));
    }
}
