package test;

import java.util.concurrent.FutureTask;

public class Demo {

    public static void main(String[] args) {
//        Integer[] ints = {1, 2, 3, 4, 5};
//        List list = Arrays.asList(ints);
//        list.add(6);

//        Integer a = 1111111111;
//        Integer b = 1111111111;
        Integer a = 1111111111;
        Integer b = a;
        System.out.println(a == b);
        System.out.println(a.equals(b));
//        User user1 = new User("li");
//        User user22 = new User("li");
//        User user1 = new User("li");
//        User user22 = user1;
//        System.out.println(user1 == user22);
//        System.out.println(user1.equals(user22));
//        User user = null;
//        System.out.println(user.equals(null));
//        Node[] aaa = new Node[111];
//        System.out.println(aaa);
//        User user = new User("12");
//        User user1 = user;
//        user1.name = "1";
//        System.out.println(user.name);
//        aaa(user);
//        System.out.println(user.name);
//        int[] a = new int[]{4,3,2,7,8,2,3,1};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//        String str = new String("asasasa");
//        str.isEmpty();
//        System.out.println(1 << 1);
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put(null, null);
//        Hashtable<String, String> hashtable = new Hashtable<>();
//        hashtable.put(null, "fguhrfghf");
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.execute(() -> {
//
//        });
//        executorService.submit(() -> {
//
//        },12);
//        int a = 'a' + 5;
//        float b = 5 + 5.5f;
//        double c = 5 + 5.5;
//        System.out.println(a);
//        Object o1 = true ? new Integer(1) : new Double(2.0);
//        Object o2;
//        if (true) {
//            o2 = new Integer(1);
//        } else {
//            o2 = new Double(2.0);
//        }
//        System.out.print(o1);
//        System.out.print(" ");
//        System.out.print(o2);
//        System.out.println(tableSizeFor(65));
//        boolean[][] aaa = new boolean[5][5];
//        Arrays.fill(aaa, true);
//        System.out.println(aaa[2][1]);
//        System.out.println(Integer.MAX_VALUE);
        System.out.println("============");
        String A = "abc";
        String B = new String("abc") + new String("bcd");
        B.intern();
        String q = "abcbcd";
        System.out.println("1212121212121");
        System.out.println(B == q);
        System.out.println("121212121212121");
        String C = new String("abc");
        String D = "abc";
        System.out.println(A == B);
        System.out.println(A == C);
        System.out.println(A == D);
        System.out.println(B == C);
        System.out.println(B == D);
        System.out.println(C == D);
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

    public static void aaa(User user) {
        User user1 = new User("121212");
        user = user1;
    }
}
