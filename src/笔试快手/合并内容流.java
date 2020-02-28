package 笔试快手;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 合并内容流 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
//        sc.nextLine();
        String str2 = sc.nextLine();
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");
        List<String> list = new ArrayList<>();
        list.add(s1[0]);
        int index = 0;
        for (int i = 1; i < s1.length; i++) {
            if (i % 4 == 0) {
                boolean a = index == s2.length ? false : list.add(s2[index++]);
                list.add(s1[i]);
                continue;
            }
            list.add(s1[i]);
        }
        if (index < s2.length) {
            for (int i = index; i < s2.length; i++) {
                list.add(s2[i]);
            }
        }
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
