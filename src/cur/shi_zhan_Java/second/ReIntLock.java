package cur.shi_zhan_Java.second;

import java.util.concurrent.locks.ReentrantLock;

public class ReIntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public ReIntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReIntLock reIntLock1 = new ReIntLock(1);
        ReIntLock reIntLock2 = new ReIntLock(2);
        Thread t1 = new Thread(reIntLock1);
        Thread t2 = new Thread(reIntLock2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}
