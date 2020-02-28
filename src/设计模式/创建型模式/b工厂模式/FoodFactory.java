package 设计模式.创建型模式.b工厂模式;

/**
 * 简单工厂模式很简单，如果它能满足我们的需要，我觉得就不要折腾了。之所以需要引入工厂模式，是因为我们往往需要使用两个或两个以上的工厂。
 */
public interface FoodFactory {
    Food makeFood(String name);
}
