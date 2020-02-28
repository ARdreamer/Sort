package cur;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    //可重入锁
    private ReentrantLock lock = new ReentrantLock();
    //Condition信号1
    private Condition c1 = lock.newCondition();
    //Condition信号2
    private Condition c2 = lock.newCondition();
    private volatile int count = 10;
    public void countMethod(){
        Thread t1 = new Thread("T1"){
            public void run(){
                while(count < 100){
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" +count);
                        count ++;
                        c1.await();//c1将线程1从运行状态->阻塞等待

                        c2.signal();//c2将线程2从阻塞等待->唤醒状态


                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally{
                        lock.unlock();
                    }
                }
            }
        };
        Thread t2 = new Thread("T2"){
            public void run(){
                while(count < 100){
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" +count);
                        count ++;
                        c1.signal();//c1将线程1从阻塞等待->唤醒状态
                        c2.await();//c2将线程2从运行状态->阻塞等待
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally{
                        lock.unlock();
                    }

                }
            }
        };

        //线程t1启动
        t1.start();
        while(count == 0){//保证t1先执行
        }
        //线程t2启动
        t2.start();

    }
    public static void main(String[] args) {
        new ThreadTest().countMethod();
    }
}

