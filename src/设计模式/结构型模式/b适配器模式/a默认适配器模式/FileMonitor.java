package 设计模式.结构型模式.b适配器模式.a默认适配器模式;

import java.io.File;

public class FileMonitor extends FileAlterationListenerAdaptor {
    public FileMonitor() {
        System.out.println("no");
    }

    public FileMonitor(String sss) {
        System.out.println("hello" + sss);
    }

    @Override
    public void onFileCreate(File file) {
        doSomething();
    }

    @Override
    public void onFileChange(File file) {
        doSomething();
    }

    private void doSomething() {
    }

}
