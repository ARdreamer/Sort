package 设计模式.结构型模式.b适配器模式.a默认适配器模式;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = FileMonitor.class.getConstructor(String.class);
        constructor.newInstance("ad");
        FileMonitor.class.getConstructor().newInstance();
        List<String> list = Arrays.asList("A1123", "A1345", "A1456");
        list.stream().map(item -> item.substring(0, 1).toLowerCase() + item.substring(1)).forEach(System.out::println);

    }
}
