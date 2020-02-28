package 设计模式;

public class A {
    public static void main(String[] args) {
        String str1 = "str";
        String str2 = "ing";
        String str3 = str1 + str2;
        str3.intern();
        String str4 = "string";
        System.out.println(str3 == str4);//true
        for (int i = 0; i < 5; i++) {
            str1 += "1";
        }
        str1.intern();
        str2 = "str11111";
        System.out.println(str1 == str2);

//        String str3 = "str" + "ing";//常量池中的对象
//        String str4 = str1 + str2; //在堆上创建的新的对象
//        String str5 = "string";//常量池中的对象
//        String str6 = str1 + "ing";
//        System.out.println(str3 == str4);//false
//        System.out.println(str3 == str5);//true
//        System.out.println(str4 == str5);//false
//        System.out.println(str3 == str6);//false
//        System.out.println(str4 == str6);//false
//
//        Integer a = 1;
//        Integer a1 = new Integer(1);
//        System.out.println(a == a1);
//
//        String s1 = new String("1");
//        String s2 = new String("1");
//        System.out.println(s1 == s2);
//        String s3 = "1";
//        System.out.println(s1 == s3);
//        String s4 = new String("s3") + new String("s4");
//        String s5 = s4.intern();
//        System.out.println(s4 == s5);
    }
}
