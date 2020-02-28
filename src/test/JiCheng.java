package test;

import java.util.concurrent.Callable;

public class JiCheng {
    public JiCheng() {
        System.out.println("JiCheng");
    }

    public void ji() {
        System.out.println(121);
    }

    class A extends JiCheng {
        public A() {
            System.out.println("A");
        }

        public void a() {
            System.out.println("a");
        }
    }

    class B extends A {
        public B() {
            System.out.println("B");
        }

        public void b() {
            System.out.println("b");
        }



    }

    public static void main(String[] args) {
        new JiCheng().new B();
    }

    static class asasa implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return null;
        }
    }
}
