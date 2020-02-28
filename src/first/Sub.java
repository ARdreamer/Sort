package first;

import java.util.Arrays;

public class Sub {
    public static void listAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
        } else {
            listAllSub(str, i + 1, res);
            listAllSub(str, i + 1, res + str[i]);

        }
    }

    public static void allList(char[] str, int i) {
        if (i == str.length) {
            System.out.println(Arrays.toString(str));
        } else {
            for (int j = i; j < str.length; j++) {
                swap(str, i, j);
                allList(str, i + 1);
                swap(str, i, j);
            }
        }
    }

    private static void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        String str = "abcdefg";
//        listAllSub(str.toCharArray(), 0, "");
        allList(str.toCharArray(), 0);
    }
}
