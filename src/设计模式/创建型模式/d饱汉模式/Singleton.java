package 设计模式.创建型模式.d饱汉模式;

/**
 * 双重检查，指的是两次检查 instance 是否为 null。
 * <p>
 * volatile 在这里是需要的，希望能引起读者的关注。
 * <p>
 * 很多人不知道怎么写，直接就在 getInstance() 方法签名上加上 synchronized，这就不多说了，性能太差。
 * <p>
 * 这里需要指出一点，volatile和synchronized是都有有序性的，但是他俩有些不大一样
 * volatile修饰在变量上，他禁止volatile前后重排序保证有序性
 * synchronized则是修饰代码块,他保证的是修饰的代码块前后的有序性，不会保证代码块里面的有序性
 * 所以代码块中的代码可能会发生重排序
 * <p>
 * 这里讲明：一个对象创建分为三个过程：
 * 1.为对象分配内存空间
 * 2.初始化对象
 * 3.将引用指向分配的内存地址
 * <p>
 * 所以为什么不加volatile就有可能出错呢？
 * 因为2 3可能会发生重排序，外部访问对象可能还没有初始化，也就是会报空指针异常
 * <p>
 * 所以需要加volatile禁止指令重排序
 */

/**
 * 对于双重锁检查那个例子，我有一个疑问，A如果没有完成实例的初始化，锁应该不会释放的，B是拿不到锁的，怎么还会出问题呢？
 * <p>
 * 个人认为CPU时间片切换后，线程B刚好执行到第一次判断instance==null，此时不为空，不用进入synchronized里，就将还未初始化的instance返回了
 * <p>
 * 线程A进入第二个判空条件，进行初始化时，发生了时间片切换，即使没有释放锁，线程B刚要进入第一个判空条件时，发现条件不成立，直接返回instance引用，不用去获取锁。
 * 如果对instance进行volatile语义声明，就可以禁止指令重排序，避免该情况发生。
 * <p>
 * 两个线程都过了第一层判空后，第二个线程不会出现文中说的空指针异常。
 * 因为JSR-133中的happens-before规则。
 * 1.一个线程中的每个操作先于线程中的后续操作。
 * 2.对一个锁的解锁先于随后对这个锁的加锁。
 * 3.传递性。
 * 综合以上三条规则，第一个线程的对象初始化完成先于解锁，第一个线程的解锁先于第二个线程的加锁。
 * 所以，真如作者所说第二线程如果过了第一层的判空校验，下步就要加锁，加锁后其实对象在线程一中已经初始化结束，不会出现NPE。
 * 但例子的确会出现NPE问题，出现的场景却是，线程二没有进行到第一层判空操作，线程一到了文中说的时间片结束，让出CPU，线程二判空，否，执行对象调用方法。
 * <p>
 * synchronized修饰的代码块里，会出现线程切换么？我理解的synchronized作用就是同步执行，不会线程切换？
 * 在同步块里，线程也可能被操作系统剥夺cpu的使用权，但是其他线程此时是拿不到锁，所以其他线程不会执行同步块的代码
 */
public class Singleton {
    // 首先，也是先堵死 new Singleton() 这条路
    private Singleton() {
    }

    // 和饿汉模式相比，这边不需要先实例化出来，注意这里的 volatile，它是必须的
    private static volatile Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            // 加锁
            synchronized (Singleton.class) {
                // 这一次判断也是必须的，不然会有并发问题
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
