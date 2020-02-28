package 笔试网易;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] x = new int[T];
        for (int i = 0; i < T; i++) {
            x[i] = in.nextInt();
        }
        for (int i = 0; i < T; i++) {
            if (x[i] < 10) {
                System.out.println(x[i]);
                continue;
            }
            System.out.println(tenToNum(x[i]));
        }
    }

    public static int tenToNum(int n) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        while (n != 0) {
//            sum += (n % 10);
            list.add(n % 10);
            n /= 10;
        }
        Collections.sort(list);
        for (Integer i : list) {
            sum = sum * 10 + i;
        }
        return sum;
    }
}
