package 设计模式.创建型模式.c饿汉模式;

import java.util.Date;

/**
 * 很多人都能说出饿汉模式的缺点，可是我觉得生产过程中，很少碰到这种情况：
 *
 * 你定义了一个单例的类，不需要其实例，可是你却把一个或几个你会用到的静态方法塞到这个类中。
 */
public class Singleton {
    // 首先，将 new Singleton() 堵死
    private Singleton() {
    }

    // 创建私有静态实例，意味着这个类第一次使用的时候就会进行创建
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    // 瞎写一个静态方法。这里想说的是，如果我们只是要调用 Singleton.getDate(...)，
    // 本来是不想要生成 Singleton 实例的，不过没办法，已经生成了
    public static Date getDate(String mode) {
        return new Date();
    }
}
