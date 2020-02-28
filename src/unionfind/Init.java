package unionfind;

public class Init {
//    static {
//        System.out.println("static");
//    }
//    private static int aaa = method();
//
//    public static int method(){
//        System.out.println("1121212121");
//        return 1;
//    }

    static class QQQ {
        int a;
    }

    public static void main(String[] args) {
        QQQ qqq = new QQQ();
        qqq.a = 12;
        change(qqq);
        System.out.println(qqq.a);
    }

    public static void change(QQQ qqq) {
        QQQ qqqq = new QQQ();
        qqqq.a = 13;
//        qqq.a = qqqq.a;
        qqq = qqqq;
    }
}
