package 笔试贝壳;

import test.User;
import 继承.father;

import java.util.PriorityQueue;

public class E extends father {
    public void adadadad() {
        PriorityQueue<User> priorityQueue = new PriorityQueue<>((u1, u2) -> u1.a - u2.a == 0 ? u1.b - u2.b : u1.a - u2.a);
        PriorityQueue<User> priorityQueue1 = new PriorityQueue<>((u1, u2) -> {
            if (1 == 1)
                return 1;
            return 2;
        });
    }
}
