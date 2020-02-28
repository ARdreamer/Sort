package test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    Unsafe unsafe = null;
    static UnsafeTest test = new UnsafeTest();

    public UnsafeTest() {
        Field f = null;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            System.out.println(unsafe);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private long count = 10000;

    public void increment() throws NoSuchFieldException {
        Field f = UnsafeTest.class.getDeclaredField("count");
        f.setAccessible(true);
        unsafe.getAndAddLong(test, unsafe.objectFieldOffset(f), -1);
        System.out.println(count);
    }

    public void incrementInt(int n) {
        try {
            increment();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2000; ++i) {
                test.incrementInt(2000);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 4000; ++i) {
                test.incrementInt(4000);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 4000; ++i) {
                test.incrementInt(4000);
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }

}

