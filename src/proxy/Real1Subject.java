package proxy;

public class Real1Subject implements Subject {
    public Real1Subject(){

    }
    @Override
    public void request() {
        System.out.println("real1Subject");
    }
}
