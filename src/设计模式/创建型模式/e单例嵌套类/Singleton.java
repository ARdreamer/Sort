package 设计模式.创建型模式.e单例嵌套类;

/**
 * 注意，很多人都会把这个嵌套类说成是静态内部类，严格地说，内部类和嵌套类是不一样的，它们能访问的外部类权限也是不一样的。
 * <p>
 * 当 Singleton 类被加载时，静态内部类 Holder 没有被加载进内存。
 * 只有当调用 getInstance() 方法从而触发 Holder.instance 时 Holder 才会被加载，
 * 此时初始化 instance 实例，并且 JVM 能确保 instance 只被实例化一次。
 */
public class Singleton {
    private Singleton() {
    }

    // 主要是使用了 嵌套类可以访问外部类的静态属性和静态方法 的特性
    private static class Holder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.instance;
    }

}
