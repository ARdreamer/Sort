package proxy;

public class RealSubject implements Subject {
    public RealSubject() {

    }

    @Override
    public void request() {
        System.out.println("realSubject");
    }
}
