package 笔试Keep;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
                String pwd = sc.next();
//            String pwd = sc.nextLine();
            int count = containsCount(pwd);
            if (count < 2 || (pwd.charAt(0) >= '0' && pwd.charAt(0) <= '9') || pwd.length() < 8) {
                System.out.println("NO");
                continue;
            }
            boolean flag = false;
            for (char c : pwd.toCharArray()) {
                if (!isAllowed(c)) {
                    //System.out.println("NO");
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static boolean isAllowed(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isA(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isa(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static int containsCount(String pwd) {
        boolean numF = false;
        boolean aF = false;
        boolean AF = false;
        for (char c : pwd.toCharArray()) {
            if (isa(c)) {
                aF = true;
            } else if (isA(c)) {
                AF = true;
            } else if (isNum(c)) {
                numF = true;
            }
        }
        int count = 0;
        if (numF)
            count++;
        if (aF)
            count++;
        if (AF)
            count++;
        return count;
    }
}
