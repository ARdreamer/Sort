package 笔试Keep;

import java.util.HashMap;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.nextLine();
        String l2 = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : l1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : l2.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) == 0) {
                    System.out.println(c);
                    break;
                } else {
                    map.put(c, map.get(c) - 1);
                }
            } else {
                System.out.println(c);
                break;
            }
        }
    }
}
