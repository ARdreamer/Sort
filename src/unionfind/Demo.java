package unionfind;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Single> constructor = Single.class.getConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Single single = constructor.newInstance("12", 2);
        System.out.println(single.getKey());
//        Constructor<SSS> constructor = SSS.class.getConstructor(int.class, int.class);
//        constructor.setAccessible(true);
//        SSS single = constructor.newInstance(111, 2);
//        System.out.println(single.getKey());
    }

    @Test
    public void testList() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
