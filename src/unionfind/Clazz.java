package unionfind;

class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");
    }
}

class Father extends Grandpa {
    static {
        System.out.println("爸爸在静态代码块");
    }

    public static int factor = 26;

    public Father() {
        System.out.println("我是爸爸~");
    }
}

class Son extends Father {

    static {
        System.out.println("儿子在静态代码块");
    }

    public static int qw = 121;

    public Son() {
        System.out.println("我是儿子~");
    }
}

public class Clazz {
//    public static int cc = 6;

    public static void main(String[] args) {

//        System.out.println(1);
//        System.out.println("爸爸的岁数:" + Son.factor);    //入口
        String ss = "12";
//        for (int i = 0; i < 10000; i++)
//            ss += i;
//        System.out.println(ss);'
        System.out.println(ss.hashCode());
        System.out.println(ss.hashCode() ^ (ss.hashCode() >>> 16));
    }

}
