package T360;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long mr = Integer.MIN_VALUE;
        long mc = Integer.MIN_VALUE;
        long nr = Integer.MAX_VALUE;
        long nc = Integer.MAX_VALUE;
        for (long i = 0; i < num; i++) {
            long row = scanner.nextInt();
            long col = scanner.nextInt();
            nr = Math.min(row, nr);
            nc = Math.min(col, nc);
            mr = Math.max(mr, row);
            mc = Math.max(mc, col);
        }
        mr = mr - nr;
        mc = mc - nc;

        System.out.println(Math.max(mr * mr, mc * mc));
    }
}
