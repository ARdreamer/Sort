package cur;

public class 交替打印1 {
    public synchronized void print(int i) throws InterruptedException {
        this.notify();
        System.out.println(i);
        this.wait();
    }

    public static void main(String[] args) {
        交替打印1 qw = new 交替打印1();
        new Thread(() -> {
            for (int i = 0; i <= 10; i+=2) {
                try {
                    qw.print(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i < 10; i+=2) {
                try {
                    qw.print(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
