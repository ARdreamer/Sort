package 设计模式.结构型模式.b适配器模式.b对象适配器模式;

/**
 * 来看一个《Head First 设计模式》中的一个例子，
 * 我稍微修改了一下，看看怎么将鸡适配成鸭，这样鸡也能当鸭来用。
 * 因为，现在鸭这个接口，我们没有合适的实现类可以用，所以需要适配器。
 * <p>
 * 鸭接口有 fly() 和 quare() 两个方法，鸡 Cock 如果要冒充鸭，fly() 方法是现成的，
 * 但是鸡不会鸭的呱呱叫，没有 quack() 方法。这个时候就需要适配了：
 */
public class WildCock implements Cock {
    public void gobble() {
        System.out.println("咕咕叫");
    }

    public void fly() {
        System.out.println("鸡也会飞哦");
    }

}
