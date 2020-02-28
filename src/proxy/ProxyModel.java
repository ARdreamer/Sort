package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyModel {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Real1Subject real1Subject = new Real1Subject();
        Class<?> aClass = realSubject.getClass();
        InvocationHandler invocationHandler = new ProxySubject(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), invocationHandler);
        subject.request();

        InvocationHandler invocation1Handler = new ProxySubject(real1Subject);
        Subject subject1 = (Subject) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), invocation1Handler);
        subject1.request();
    }
}

