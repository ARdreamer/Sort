package 笔试贝壳;

import java.util.Scanner;

/**
 * 82%
 *
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 小希偶然得到了传说中的月光宝盒,然而打开月光宝盒需要一串密码。虽然小希并不知道密码具体是什么，
 * 但是月光宝盒的说明书上有着一个长度为 n (2 <= N <= 50000)的序列 a (-10^9 <= a[i] <= 10^9)的范围内。
 * 下面写着一段话：密码是这个序列的最长的严格上升子序列的长度(严格上升子序列是指，子序列的元素是严格递增的，
 * 例如: [5,1,6,2,4]的最长严格上升子序列为[1,2,4])，请你帮小希找到这个密码。
 * <p>
 * <p>
 * 输入
 * 第1行：1个数N，N为序列的长度(2<=N<=50000)
 * <p>
 * 第2到 N+1行：每行1个数，对应序列的元素(-10^9 <= a[i] <= 10^9)
 * <p>
 * 输出
 * 一个正整数表示严格最长上升子序列的长度
 * <p>
 * <p>
 * 样例输入
 * 8
 * 5
 * 1
 * 6
 * 8
 * 2
 * 4
 * 5
 * 10
 * 样例输出
 * 5
 */
public class 月光宝盒的密码 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();
//        n = 8;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cin.nextInt();
        }
//        int[] nums = new int[]{5, 1, 6, 8, 2, 4, 5, 10};

        int[] dp = new int[10000];
        int len = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    len = Math.max(len, dp[i]);
                }
            }
        }
        System.out.println(len);
    }
}
