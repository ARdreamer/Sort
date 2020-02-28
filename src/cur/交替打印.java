package cur;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 交替打印 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition ji = lock.newCondition();
    private Condition ou = lock.newCondition();
    public volatile int q = 0;

    public void crea() throws InterruptedException {
        Thread thread1 = new Thread("T1") {
            @Override
            public void run() {
                while (q <= 100) {
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + ":\t" + q);
                        q++;
                        ou.await();
                        ji.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        Thread thread2 = new Thread("T2") {
            @Override
            public void run() {
                while (q <= 99) {
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + ":\t" + q);
                        q++;
                        ou.signal();
                        ji.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();

    }

    public static void main(String[] args) throws InterruptedException {
        交替打印 qw = new 交替打印();
        qw.crea();
    }
}
