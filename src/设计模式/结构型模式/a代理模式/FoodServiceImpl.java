package 设计模式.结构型模式.a代理模式;

public class FoodServiceImpl implements FoodService {
    @Override
    public Food makeChicken() {
        Food f = new Chicken();
//        f.setChicken("1kg");
//        f.setSpicy("1g");
//        f.setSalt("3g");
        return f;
    }

    @Override
    public Food makeNoodle() {
        Food f = new Noodle();
//        f.setNoodle("500g");
//        f.setSalt("5g");
        return f;
    }
}
