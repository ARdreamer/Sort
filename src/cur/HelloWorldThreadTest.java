package cur;

public class HelloWorldThreadTest {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = threadGroup;
        while (threadGroup != null) {
            topGroup = threadGroup;
            threadGroup = topGroup.getParent();
        }
        int nowThreads = topGroup.activeCount();
        Thread[] lsThread = new Thread[nowThreads];
        topGroup.enumerate(lsThread);
        for (int i = 0; i < nowThreads; i++) {
            System.out.println("线程number：" + i + " = " + lsThread[i].getName());
        }
    }
}
