package test;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class TTT {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        String a = "hello";
//        String b = "he" + new String("llo");
//        String c = "he" + "llo";
//        System.out.println(a == b);
//        System.out.println(a == c);
//        Class cl = ArrayList.class;
//        Constructor arrayList = cl.getConstructor();
//        arrayList.setAccessible(true);
//        ArrayList o = (ArrayList) arrayList.newInstance();
//        o.add(1);
//        o.add("2");
//        for (Object oo : o) {
//            System.out.println(oo);
//        }
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(1);
//        arrayList.add("2");
//        for (Object oo : arrayList) {
//            System.out.println(oo);
//        }
        System.out.println(returnTest());
//        final Unsafe unsafe = Unsafe.getUnsafe();
        Integer[] a = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 11, 2121, 13, 453, 67, 89, 454, 23, 23, 567, 78};
        Arrays.sort(a, 0, 11, (c1, c2) -> c2 - c1);
        System.out.println(Arrays.toString(a));
    }

    public static boolean returnTest() {
        try {
            return true;
        } catch (Exception e) {
            return true;
        } finally {
            System.out.println("finally");
            return false;
        }
    }

}
