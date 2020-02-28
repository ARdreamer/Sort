package cur;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSRF {
    public int i = 111;
    public int j = 111;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field th = Unsafe.class.getDeclaredField("theUnsafe");
        th.setAccessible(true);
        Unsafe unsafe = (Unsafe) th.get(Unsafe.class);
        Object i = unsafe.objectFieldOffset(UnSRF.class.getDeclaredField("i"));
        Object j = unsafe.objectFieldOffset(UnSRF.class.getDeclaredField("j"));
        System.out.println(i);
        System.out.println(j);
//        ThreadTest threadTest = new ThreadTest();
//        Class<?> clazz = threadTest.getClass();
//        Field count = clazz.getDeclaredField("count");
//        count.setAccessible(true);
//        System.out.println(count.get(threadTest));
    }
}
