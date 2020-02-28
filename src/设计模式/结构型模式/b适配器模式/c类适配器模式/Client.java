package 设计模式.结构型模式.b适配器模式.c类适配器模式;

// 已存在的、具有特殊功能、但不符合我们既有的标准接口的类
class Adaptee {
    public void specificRequest() {
        System.out.println("被适配类 具有特殊功能...");
    }
}

// 目标接口，或称为标准接口
interface Target {
    public void request();
}

// 具体目标类，只提供普通功能
class ConcreteTarget implements Target {
    public void request() {
        System.out.println("普通类 具有普通功能...");
    }
}

// 适配器类，继承了被适配类，同时实现标准接口
class Adapter extends Adaptee implements Target {
    public void request() {
        super.specificRequest();
    }
}

// 测试类
public class Client {
    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();//实例化一个普通类
        concreteTarget.request();

        // 使用特殊功能类，即适配类
        Target adapter = new Adapter();
        adapter.request();
    }
}