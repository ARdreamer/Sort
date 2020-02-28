package lru;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class JiaoTi {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition odd = lock.newCondition();
    public static Condition even = lock.newCondition();
    public static final int COUNT = 100;
    public static volatile int i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            while (i < COUNT) {
                while (i % 2 == 0) {
                    try {
                        odd.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i++);
                even.signal();
            }
            lock.unlock();
        }).start();
        new Thread(() -> {
            lock.lock();
            while (i <= COUNT) {
                while (i % 2 == 1) {
                    try {
                        even.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i++);
                odd.signal();
            }
            lock.unlock();
        }).start();
    }

}
