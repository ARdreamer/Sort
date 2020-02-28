package 设计模式.结构型模式.b适配器模式.a默认适配器模式;

import java.io.File;

/**
 * 我们用 Appache commons-io 包中的 FileAlterationListener 做例子，
 * 此接口定义了很多的方法，用于对文件或文件夹进行监控，一旦发生了对应的操作，就会触发相应的方法。
 * <p>
 * 此接口的一大问题是抽象方法太多了，如果我们要用这个接口，
 * 意味着我们要实现每一个抽象方法，如果我们只是想要监控文件夹中的文件创建和文件删除事件，
 * 可是我们还是不得不实现所有的方法，很明显，这不是我们想要的。
 * <p>
 * 所以，我们需要下面的一个适配器，它用于实现上面的接口，
 * 但是所有的方法都是空方法，这样，我们就可以转而定义自己的类来继承下面这个类即可。
 */
public interface FileAlterationListener {
    void onStart(final FileAlterationObserver observer);

    void onDirectoryCreate(final File directory);

    void onDirectoryChange(final File directory);

    void onDirectoryDelete(final File directory);

    void onFileCreate(final File file);

    void onFileChange(final File file);

    void onFileDelete(final File file);

    void onStop(final FileAlterationObserver observer);
}
