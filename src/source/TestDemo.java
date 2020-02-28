package source;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {

    public static final int c = 1;
    public static int d = 1;

    @Test
    public void test01() {

    }

    private void a() {
        System.out.println(12);
    }

    public static void main(String[] args) {
//        System.out.println(null == null);
//        Map<User, Integer> map = new HashMap<>();
//        map.put(new User(),1);
//        List<Integer> list = new ArrayList<>();
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        list.add(null);
//        System.out.println((Integer.MAX_VALUE+1)==Integer.MIN_VALUE);
        int k = 0;
        for (int j = 0; j < 10; ) {
            k++;
            j++;
        }
        System.out.println(k);

        int i = 0;
        for (int j = 0; j < 10; j = ++j) {
//            System.out.println(j);
            i++;
        }
        System.out.println(i);
        int[] a = {1, 3, 5, 7, 9};
        for (int o : a) {
            System.out.println(o);
        }
        StringBuilder stringBuilder = new StringBuilder().append("12345678912312313");
        System.out.println(stringBuilder.replace(9,15,"1"));
        System.out.println(stringBuilder.delete(0, 5));
    }
}
