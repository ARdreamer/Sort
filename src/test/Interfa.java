package test;

import java.util.List;
import java.util.Queue;

public interface Interfa extends List, Queue {
    int a = 1;

    default void aaa() {
        System.out.println("!212");
    }

    public static int ad() {
        return 1;
    }

    static int sf() {
        return 1;
    }
}
