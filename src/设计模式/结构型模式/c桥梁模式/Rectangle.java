package 设计模式.结构型模式.c桥梁模式;

public class Rectangle extends Shape {
    private int x;
    private int y;

    public Rectangle(int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
    }

    public void draw() {
        drawAPI.draw(0, x, y);
    }

}
