package 笔试贝壳;

import java.util.Arrays;
import java.util.Scanner;

/**
 * AC 100%
 * <p>
 * <p>
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 131072KB；其他语言 655360KB
 * 题目描述：
 * 举重大赛开始了，为了保证公平，要求比赛的双方体重较小值要大于等于较大值的90%，那么对于这N个人最多能进行多少场比赛呢，任意两人之间最多进行一场比赛。
 * <p>
 * 输入
 * 第一行N，表示参赛人数（2<=N<=10^5）
 * <p>
 * 第二行N个正整数表示体重（0<体重<=10^8）
 * <p>
 * 输出
 * 一个数，表示最多能进行的比赛场数
 * <p>
 * <p>
 * 样例输入
 * 5
 * 1 1 1 1 1
 * 样例输出
 * 10
 */
public class 举重大赛1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();
//        n = 5;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = cin.nextInt();
        }
//        int[] nums = new int[]{1, 1, 1, 1, 1};
        Arrays.sort(nums);
        int count = 0;
        int l = 0;
        int r = 1;
        while (l < r && l < n && r < n) {
            if (nums[l] >= nums[r] * 0.9) {
                count++;
                r++;
                if (r == n) {
                    l++;
                    r = l + 1;
                }
            } else {
                l++;
                r = l + 1;
            }
        }
        System.out.println(count);
    }
}
