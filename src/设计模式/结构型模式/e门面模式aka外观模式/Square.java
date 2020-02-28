package 设计模式.结构型模式.e门面模式aka外观模式;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
