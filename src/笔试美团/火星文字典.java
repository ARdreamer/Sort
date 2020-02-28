package 笔试美团;

import java.util.*;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 8192KB；其他语言 532480KB
 * 题目描述：
 * 已知一种新的火星文的单词由英文字母组成，但是此火星文中的字母先后顺序未知。
 * 给出一组非空的火星文单词，且此组单词已经按火星文字典序进行好了排序，请推断出此火星文中的字母先后顺序。
 * <p>
 * 输入
 * 一行文本，为一组按火星文字典序排序好的单词(单词两端无引号)，单词之间通过空格隔开
 * <p>
 * 输出
 * 按火星文字母顺序输出出现过的字母，字母之间无其他字符，如果无法确定顺序或者无合理的字母排序可能，请输出"invalid" (无需引号)
 * <p>
 * <p>
 * 样例输入
 * wrt wrf er ett rftt
 * 样例输出
 * wertf
 * <p>
 * 提示
 * 输入样例2
 * z x
 * 输出样例2
 * zx
 * <p>
 * 输入样例3
 * z x z
 * 输出样例3
 * invalid
 */
public class 火星文字典 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
//            System.out.println("invalid");
        String[] strs = line.split(" ");
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> degree = new HashMap<>();
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                degree.put(c, 0);
            }
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < strs.length - 1; i++) {
            String cur = strs[i];
            String next = strs[i + 1];
            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1)) set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        LinkedList<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : degree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            char parent = queue.poll();
            sb.append(parent);
            if (map.containsKey(parent)) {
                for (char child : map.get(parent)) {
                    degree.put(child, degree.get(child) - 1);
                    if (degree.get(child) == 0) queue.offer(child);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
