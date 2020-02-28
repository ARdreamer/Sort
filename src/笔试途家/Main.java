package 笔试途家;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        int count = t;
        while (t > 0) {
            if (s <= 0)
                break;
            if (m >= 10) {
                s -= 50;
                m -= 10;
            } else if (s < 50) {
                s -= 13;
//                m += 4;
            } else {
                m += 4;
            }
            t--;
        }
        if (s <= 0) {
            System.out.println("Yes");
            System.out.println(count - t);
        } else {
            System.out.println("No");
            System.out.println(s);
        }
    }
}
