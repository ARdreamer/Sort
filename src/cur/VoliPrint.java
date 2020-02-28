package cur;

public class VoliPrint {
    public static volatile boolean flag = true;
    public static volatile int i = 0;

    public static void test() {
        new Thread(() -> {
            while (i <= 10000) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i + "===");
                    i++;
                    flag = false;
                }
            }
        }, "T1").start();
        new Thread(() -> {
            while (i < 10000) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i + "==================");
                    i++;
                    flag = true;
                }
            }
        }, "T2").start();
    }

    public static void main(String[] args) {
        test();
//        Thread thread = new Thread(() -> {
//            System.out.println("121212");
//        });
//        thread.start();
//        thread.start();

    }
}
