package 笔试有赞.first;

import java.util.Scanner;

//60%
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int index = 0;
        int position = 0;
        int ib = 0;
        int count = 0;
        while (position < A.length()) {
            if (A.charAt(position) == B.charAt(ib)) {
                position++;
                ib++;
            } else {
                position = index + 1;
                index = position;
                ib = 0;
            }
            if (ib == B.length()) {
                ib = 0;
                count++;
                position = index + 1;
                index = position;
            }
        }
        System.out.println(count);
    }
}
