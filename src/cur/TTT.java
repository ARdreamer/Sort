package cur;

public class TTT {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {
                System.out.println("t1获取o1了");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("t1获取o2了");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (o2) {
                System.out.println("t2获取o2了");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("t2获取o1了");
                }
            }
        }).start();
    }
}
