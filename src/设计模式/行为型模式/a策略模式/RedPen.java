package 设计模式.行为型模式.a策略模式;

public class RedPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用红色笔画图，radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
