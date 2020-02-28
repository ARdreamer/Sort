package cur;

public class SynTest {
    public synchronized void m1() {
        System.out.println("m1 come");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1");
    }

    public synchronized void m2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        SynTest synTest = new SynTest();
        new Thread(() -> synTest.m1()).start();
        new Thread(() -> synTest.m2()).start();
    }
}
