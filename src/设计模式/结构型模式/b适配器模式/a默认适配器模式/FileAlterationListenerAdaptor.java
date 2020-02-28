package 设计模式.结构型模式.b适配器模式.a默认适配器模式;

import java.io.File;

/**
 * 所以，我们需要下面的一个适配器，它用于实现上面的接口，但是所有的方法都是空方法，这样，我们就可以转而定义自己的类来继承下面这个类即可。
 */
public class FileAlterationListenerAdaptor implements FileAlterationListener {
    @Override
    public void onStart(FileAlterationObserver observer) {

    }

    @Override
    public void onDirectoryCreate(File directory) {

    }

    @Override
    public void onDirectoryChange(File directory) {

    }

    @Override
    public void onDirectoryDelete(File directory) {

    }

    @Override
    public void onFileCreate(File file) {

    }

    @Override
    public void onFileChange(File file) {

    }

    @Override
    public void onFileDelete(File file) {

    }

    @Override
    public void onStop(FileAlterationObserver observer) {

    }
}
