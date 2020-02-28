package source;

import java.util.HashMap;

public class HMT {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(3);
//        for (int i = 0; i < 50; i++) {
//            map.put(i + "", i);
//        }
//        System.out.println(findNotRe("dvdf"));
        System.out.println(Integer.MAX_VALUE);
    }

    public static int findNotRe(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0)
            return 0;
        int count = 1;
        String s = str.substring(0, 1);
        int max = 1;
        for (int i = 1; i < str.length(); i++) {
            if (s.indexOf(str.charAt(i)) == -1) {
                count++;
                max = Math.max(max, count);
                s += str.charAt(i);
            } else {
                max = Math.max(max, count);
                count = 1;
                s = str.substring(i, i + 1);
            }
        }
        return max;
    }
}
