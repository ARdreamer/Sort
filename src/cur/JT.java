package cur;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class JT {
    public static int i = 0;
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition conJi = lock.newCondition();
    public static Condition conOu = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int count = 0;
            try {
                lock.lock();
                while (i <= 10000) {
                    while (i % 2 == 1)
                        conOu.await();
                    System.out.println(Thread.currentThread().getName() + "\t" + count);
                    count += 2;
                    i++;
                    conJi.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            int count = 1;
            try {
                lock.lock();
                while (i < 10000) {
                    while (i % 2 == 0)
                        conJi.await();
                    System.out.println(Thread.currentThread().getName() + "\t" + count);
                    count += 2;
                    i++;
                    conOu.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();

    }
}
