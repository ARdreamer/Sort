package 笔试贝壳;

import java.util.Scanner;

/**
 * ac 100%
 * <p>
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 给出n个正整数，要求找出相邻两个数字中差的绝对值最小的一对数字，如果有差的绝对值相同的，则输出最前面的一对数。
 * <p>
 * 2<n<=100，正整数都在10^16范围内
 * <p>
 * 输入
 * 输入包含2行，第一行为n，第二行是n个用空格分隔的正整数。
 * <p>
 * 输出
 * 输出包含一行两个正整数，要求按照原来的顺序输出
 * <p>
 * <p>
 * 样例输入
 * 9
 * 1 3 4 7 2 6 5 12 32
 * 样例输出
 * 3 4
 */
public class 计算绝对值 {
    //    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        while (cin.hasNextInt()) {
//            int n = cin.nextInt();
//            long[] nums = new long[n];
//            long a = 0, b = 0, min = Integer.MAX_VALUE;
//            for (int i = 0; i < n; i++) {
//                nums[i] = cin.nextLong();
//            }
//            for (int i = 0; i < n - 1; i++) {
//                long abs = Math.abs(nums[i + 1] - nums[i]);
//                if (abs < min) {
//                    min = abs;
//                    a = nums[i];
//                    b = nums[i + 1];
//                }
//            }
//            System.out.println(a + " " + b);
//        }
//
//    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
//        while (cin.hasNextInt()) {
        // 读取N 和 M
//            n = cin.nextInt();
        n = 9;
        int[] nums = new int[]{1, 3, 4, 7, 2, 6, 5, 12, 32};
        int a = 0, b = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = cin.nextInt();
            if (i == 0)
                continue;
            int abs = Math.abs(nums[i] - nums[i - 1]);
            if (abs < min) {
                min = abs;
                a = nums[i];
                b = nums[i + 1];
            }
        }
//        for (int i = 0; i < n - 1; i++) {
//            int abs = Math.abs(nums[i + 1] - nums[i]);
//            if (abs < min) {
//                min = abs;
//                a = nums[i];
//                b = nums[i + 1];
//            }
//        }
        System.out.println(a + " " + b);

    }

    public static void main1(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            long n = cin.nextLong();
            long[] nums = new long[(int) n];
            long a = 0, b = 0, min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextLong();
                if (i == 0)
                    continue;
                long abs = Math.abs(nums[i] - nums[i - 1]);
                if (abs < min) {
                    min = abs;
                    a = nums[i - 1];
                    b = nums[i];
                }
            }
            /*for (int i = 0; i < n - 1; i++) {
                int abs = Math.abs(nums[i + 1] - nums[i]);
                if (abs < min) {
                    min = abs;
                    a = nums[i];
                    b = nums[i + 1];
                }
            }*/
            System.out.println(a + " " + b);
        }
    }

}
