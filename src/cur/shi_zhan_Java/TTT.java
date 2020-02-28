package cur.shi_zhan_Java;

public class TTT {
    public static void main(String[] args) {
//        String a = "hello";
//        String b = "hello";
//        System.out.println(a == b);
//        Integer a = null;
//        Integer b = a;
//        System.out.println(a==b);
//        int a = 1;
//        Integer b = new Integer(200);
//        Integer a = 200;
//        System.out.println(a == b);
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);


        String s = new String("1");
        String s2 = s.intern();
        String s3 = "1";
        System.out.println(s == s2);
        System.out.println(s2 == s3);

    }
}
