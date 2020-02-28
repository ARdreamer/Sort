package 设计模式.结构型模式.a代理模式;

/**
 * 我们发现没有，代理模式说白了就是做 “方法包装” 或做 “方法增强”。
 * 在面向切面编程中，其实就是动态代理的过程。
 * 比如 Spring 中，我们自己不定义代理类，但是 Spring 会帮我们动态来定义代理，
 * 然后把我们定义在 @Before、@After、@Around 中的代码逻辑动态添加到代理中。
 * <p>
 * 说到动态代理，又可以展开说，Spring 中实现动态代理有两种，
 * 一种是如果我们的类定义了接口，
 * 如 UserService 接口和 UserServiceImpl 实现，那么采用 JDK 的动态代理，感兴趣的读者可以去看看 java.lang.reflect.Proxy 类的源码；
 * 另一种是我们自己没有定义接口的，Spring 会采用 CGLIB 进行动态代理，它是一个 jar 包，性能还不错。
 */
public class App {
    public static void main(String[] args) {
        FoodService foodService = new FoodServiceProxy();
        foodService.makeChicken();
        foodService.makeNoodle();
    }
}
