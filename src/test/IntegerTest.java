package test;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);//false
        Integer c = 1;
        Integer d = 1;
        System.out.println(a == c);//false
        System.out.println(c == d);//true
    }
}
