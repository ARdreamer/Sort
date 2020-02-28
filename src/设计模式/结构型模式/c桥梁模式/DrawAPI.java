package 设计模式.结构型模式.c桥梁模式;

/**
 * 理解桥梁模式，其实就是理解代码抽象和解耦。
 * <p>
 * 我们首先需要一个桥梁，它是一个接口，定义提供的接口方法。
 */
public interface DrawAPI {
    public void draw(int radius, int x, int y);
}
