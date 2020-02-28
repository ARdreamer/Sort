package test;

public class StringTest {
    protected void aaa() throws InterruptedException {
        synchronized (this) {
            this.wait();
            ;
        }
    }

    public synchronized void aa() {

    }

    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyza";
        //qbcdefghijklmnopqrstuvwxyzq
        System.out.println(str.replace("a", "q"));
        //qbcdefghijklmnopqrstuvwxyza
        System.out.println(str.replaceFirst("a", "q"));
        //cdefghijklmnopqrstuvwxyza
        System.out.println(str.substring(2));
        //cde
        System.out.println(str.substring(2, 5));
        //abcdefghijklmnopqrstuvwxyzawww
        System.out.println(str.concat("www"));
        //4
        System.out.println(str.indexOf("e"));
        //22
        System.out.println(str.lastIndexOf("w"));
        //false
        System.out.println(str.startsWith("b"));
        System.out.println("123".substring(0, 1));

        String a = new String("a");
        String b = new String("b");
        String d = a + b;
        d.intern();
        String c = "ab";
        System.out.println(c == d);
    }
}
