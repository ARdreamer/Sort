package 设计模式.创建型模式.h原型模式;

public class Model {
    /**
     * 这是我要说的创建型模式的最后一个设计模式了。
     *
     * 原型模式很简单：有一个原型实例，基于这个原型实例产生新的实例，也就是“克隆”了。
     *
     * Object 类中有一个 clone() 方法，它用于生成一个新的对象，当然，如果我们要调用这个方法，java 要求我们的类必须先实现 Cloneable 接口，此接口没有定义任何方法，但是不这么做的话，在 clone() 的时候，会抛出 CloneNotSupportedException 异常。
     *
     * protected native Object clone() throws CloneNotSupportedException;
     * java 的克隆是浅克隆，碰到对象引用的时候，克隆出来的对象和原对象中的引用将指向同一个对象。通常实现深克隆的方法是将对象进行序列化，然后再进行反序列化。
     *
     * 原型模式了解到这里我觉得就够了，各种变着法子说这种代码或那种代码是原型模式，没什么意义。
     */
}
