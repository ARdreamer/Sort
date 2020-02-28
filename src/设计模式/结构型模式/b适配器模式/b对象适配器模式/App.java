package 设计模式.结构型模式.b适配器模式.b对象适配器模式;

public class App {
    public static void main(String[] args) {
        // 有一只野鸡
        Cock wildCock = new WildCock();
        // 成功将野鸡适配成鸭
        Duck duck = new CockAdapter(wildCock);
        duck.quack();
        // ...
    }
}
