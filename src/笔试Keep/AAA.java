package 笔试Keep;

import java.util.concurrent.ConcurrentHashMap;

public class AAA {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//        map.put(null,null);
//        map.put(null,"");
        map.put("a","");
    }
}
