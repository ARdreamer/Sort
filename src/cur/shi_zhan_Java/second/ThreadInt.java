package cur.shi_zhan_Java.second;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ThreadInt {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            while (true) {
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("Interrupt");
//                    break;
//                }
//                Thread.yield();
//            }
//        });
//        thread.start();
//        Thread.sleep(1000);
//        thread.interrupt();
//        thread.join();
//        Object o = new Object();
////        synchronized (o){
//            o.wait();
//            o.notify();
////        }
        getParentClassLoader(new ThreadInt());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext(); ) {
            Integer i = it.next();
        }
    }

    public static void getParentClassLoader(Object object) {
        ClassLoader loader = object.getClass().getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }
}
