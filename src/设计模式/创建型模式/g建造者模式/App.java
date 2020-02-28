package 设计模式.创建型模式.g建造者模式;

public class App {
    public static void main(String[] args) {
        User d = User.builder()
                .name("foo")
                .password("pAss12345")
                .age(25)
                .build();
        System.out.println(d);
    }
}
