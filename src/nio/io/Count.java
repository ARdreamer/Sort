package nio.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Count {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\JavaSource\\SchoolOffer\\src\\nio\\io\\hello.txt")));
        String str;
        HashMap<String, Integer> hashMap = new HashMap<>();
        while ((str = bufferedReader.readLine()) != null) {
            String[] split = str.split(",");
            for (String s : split) {
                if (hashMap.containsKey(s)) {
                    hashMap.put(s, hashMap.get(s) + 1);
                } else {
                    hashMap.put(s, 1);
                }
            }
        }
        bufferedReader.close();
        for (Map.Entry<String, Integer> entries : hashMap.entrySet()) {
            System.out.println(entries.getKey() + ":" + entries.getValue());
        }
    }
}
