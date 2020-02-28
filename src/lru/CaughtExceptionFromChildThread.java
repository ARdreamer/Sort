package lru;

import java.util.HashMap;
import java.util.concurrent.ThreadFactory;

// 主线程捕获子线程错误
// 使用线程池创建

class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("child thread.");
        throw new RuntimeException("child thread throw Error");
    }
}


class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("MyExceptionHandler caught error!"+Thread.currentThread().getName());
    }
}

class MyHandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("create thread factory work.");
        Thread t = new Thread(r);
        System.out.println("set uncaughException for new thread");
        t.setUncaughtExceptionHandler(new MyExceptionHandler());

        return t;
    }
}


public class CaughtExceptionFromChildThread {

    public static void test1() {
        try {
            Thread thread = new Thread(new ThreadDemo());
            thread.start();
        } catch (Exception e) {
            System.out.println("caught error form child thread.");
        } finally {
        }

        System.out.println("main thrad end.");
    }


    public static void test2() {
        try {
            Thread thread = new Thread(new ThreadDemo());
            thread.setUncaughtExceptionHandler(new MyExceptionHandler());
            thread.start();
            System.out.println(Thread.currentThread()+"============");
        } catch (Exception e) {
            System.out.println("caught Exception form child thread.");
        } finally {
        }

        // 使用线程池创建线程并捕获
//        System.out.println("Using ExecutorService");
//        ExecutorService exc = Executors.newCachedThreadPool(new MyHandlerThreadFactory());
//        exc.execute(new ThreadDemo());
//        exc.shutdownNow();
    }

    public static void main(String[] args) {
        test2();
    }
}
