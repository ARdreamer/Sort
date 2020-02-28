package cur;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 同步交叉打印数组 {
    private static final int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static volatile int len = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition odd = lock.newCondition();
    private static Condition even = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                while (len < a.length && len < 13) {
                    while (len % 2 == 1)
                        even.await();
                    if (len < a.length)
                        System.out.println(a[len++]);
                    odd.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "T1").start();

        new Thread(() -> {
            lock.lock();
            try {
                while (len < a.length) {
                    while (len % 2 == 0)
                        odd.await();
                    if (len < a.length)
                        System.out.println(a[len++]);
                    even.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "T2").start();
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
    }
}
