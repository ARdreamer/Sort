package 笔试三六零;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 在一个古老的国度，这个国家的人并不懂得进位，
 * 但是对取模情有独钟，因此诞生了一个经典的问题，
 * 给出两个在m进制下含有n位的数字，你可以分别将这两个数各位上的数字重新排列，
 * 然后将两个数按位对应相加并分别对m取模，
 * 这样显然可以得到一个新的m进制下的n位数(可能存在前导0)，
 * 但是这个结果是不唯一的，问题来了，按照这样的操作，能够得到的最大的m进制下的数字是多少呢。
 * <p>
 * 输入
 * 输入第一行包含两个正整数n,m分别表示数字含有n位，和在m进制下。
 * <p>
 * 输入第二行和第三行分别包含n个整数，中间用空格隔开，每个整数都在0到m-1之间。每行第i个数表示的是当前数第i位上的数字。
 * <p>
 * 输出
 * 输出包含n个数字，中间用空格隔开，表示得到的最大的数字，从高位到低位输出，如6在2进制下输出3位的结果是1 1 0。
 * <p>
 * <p>
 * 样例输入
 * 5 5
 * 4 4 1 1 1
 * 4 3 0 1 2
 * 样例输出
 * 4 4 3 3 2
 * <p>
 * 提示
 * 4 4 1 1 1 →1 4 1 4 1
 * 4 3 0 1 2 →3 0 2 4 1（重排序列不唯一，数位相加后的数字为 4 4 3 8 2，对5取模即可 ）
 */
public class 序列重组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        n = sc.nextInt();
        m = sc.nextInt();
        long[] num1 = new long[n];
        long[] num2 = new long[m];
        for (int i = 0; i < n; i++) {
            num1[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            num2[i] = sc.nextLong();
        }
        ArrayList<ArrayList<Long>> long1 = noPermutation(num1);
        ArrayList<ArrayList<Long>> long2 = noPermutation(num2);
        long[] max = new long[n];
        long res = 0;
        for (ArrayList<Long> l1 : long1) {
            long[] t = new long[n];
            for (ArrayList<Long> l2 : long2) {
                for (int i = 0; i < n; i++) {
                    t[i] = (l1.get(i) + l2.get(i)) % n;
                }
                long sum = longToLong(t);
                if (sum > res) {
                    res = sum;
                    System.arraycopy(t,0,max,0,n);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i == n - 1 ? max[i] : max[i] + " ");
        }
    }

    public static long longToLong(long[] longs) {
        long sum = 0;
        for (int i = 0; i < longs.length; i++) {
            sum = sum * 10 + longs[i];
        }
        return sum;
    }


    public static ArrayList<ArrayList<Long>> noPermutation(long[] num) {
        List<ArrayList<Long>> res = new ArrayList<>();
        noPermutationHelper(num, 0, res);
        return (ArrayList) res;
    }

    private static void noPermutationHelper(long[] c, int i, List<ArrayList<Long>> res) {
        if (i >= c.length - 1) {
            ArrayList<Long> list = new ArrayList<>();
            for (long l : c) {
                list.add(l);
            }
            res.add(list);
        } else {
            for (int j = i; j < c.length; j++) {
                if (canSwap(i, j, c)) {
                    swap(c, i, j);
                    noPermutationHelper(c, i + 1, res);
                    swap(c, i, j);
                }
            }
        }
    }

    private static boolean canSwap(int i, int j, long[] c) {
        for (int k = i; k < j; k++) {
            if (c[k] == c[j])
                return false;
        }
        return true;
    }

    private static void swap(long[] c, int i, int j) {
        long t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

}
