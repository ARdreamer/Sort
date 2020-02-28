package lru;

public class QQQ {
        public static void main(String[] args) throws InterruptedException {
        int count = 1000000;
        while (count-- > 0) {
            Thread.sleep(1000);
            byte[] bytes = new byte[1000 * 1000];
            System.out.println(count);
        }
    }
//    private static final int _1MB = 1024 * 1024;

    //public //static void main(String[] args) {
//        byte[] allocation1, allocation2, allocation3, allocation4;
//        allocation1 = new byte[2 * _1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
//        allocation4 = new byte[4 * _1MB];// 出现一次MinorGC
//        System.out.println(new Random().nextInt(100));
//        StringBuilder stringBuilder = new StringBuilder();
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 11111111; i++) {
//            stringBuilder.append("as" + i);
//        }
//        System.out.println(System.currentTimeMillis() - start);
//        StringBuffer stringBuffer = new StringBuffer();
//        start = System.currentTimeMillis();
//        for (int i = 0; i < 11111111; i++) {
//            stringBuffer.append("as" + i);
//        }
//        System.out.println(System.currentTimeMillis() - start);
//        String s2 = "a" + new String("bc");
//        s2.intern();
//        String s1 = "abc";
//
//        System.out.println(s1 == s2);
//
//    }
}
