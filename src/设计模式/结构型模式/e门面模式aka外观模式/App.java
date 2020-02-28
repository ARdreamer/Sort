package 设计模式.结构型模式.e门面模式aka外观模式;

/**
 * 门面模式的优点显而易见，客户端不再需要关注实例化时应该使用哪个实现类，
 * 直接调用门面提供的方法就可以了，
 * 因为门面类提供的方法的方法名对于客户端来说已经很友好了。
 */
public class App {
    public static void main(String[] args) {
//        // 画一个圆形
//        Shape circle = new Circle();
//        circle.draw();
//
//        // 画一个长方形
//        Shape rectangle = new Rectangle();
//        rectangle.draw();
        ShapeMaker shapeMaker = new ShapeMaker();

        // 客户端调用现在更加清晰了
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();

    }

}
