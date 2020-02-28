package 设计模式.结构型模式.b适配器模式.c类适配器模式;

/**
 * https://www.javadoop.com/blogimages/design-pattern/adapter-2.png
 * 看到这个图，大家应该很容易理解的吧，通过继承的方法，适配器自动获得了所需要的大部分方法。
 * 这个时候，客户端使用更加简单，直接 Target t = new SomeAdapter(); 就可以了。
 */
public class Clazz {
    /*
     *      interface Target                class Something
     *              |                               |
     *              |                               |
     *              ---------------------------------
     *                              |
     *                              |
     *          class SomeAdapter extends Something implements Target
     *          通过继承，自动获得Something 中方法
     */
}
