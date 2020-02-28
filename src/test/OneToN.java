package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneToN {
    int[] ccc;

    int $ss;
    int ￥sdsd;
    public List<String> all(int n) {
        ccc = new int[n];
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ccc[i - 1] = i;
        }
        allHelp(list, 0);

        return list;
    }

    private void allHelp(List<String> list, int n) {
        if (n >= ccc.length - 1) {
            list.add(Arrays.toString(ccc));
        } else {
            for (int i = n; i < ccc.length; i++) {
                swap(ccc, i, n);
                allHelp(list, n + 1);
                swap(ccc, i, n);
            }
        }
    }

    private void swap(int[] c, int i, int j) {
        int t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(new OneToN().all(4));
    }
}
