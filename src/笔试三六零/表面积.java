package 笔试三六零;

import java.util.Scanner;

/**
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 将长N*M厘米的矩形区域划分成N行M列（每行每列的宽度均为1厘米），
 * 在第i行第j列的位置上叠放Ai,j个边长为1厘米的正方体（1≤Ai,j≤100），
 * 所有正方体就组成了一个立体图形，每个正方体六个面中的一部分会被其它正方体遮挡，
 * 未被遮挡的部分的总面积即为该立体图形的表面积，那么该立体图形的表面积是多少平方厘米？
 * <p>
 * 样例解释：
 * <p>
 * 输入
 * 第一行包含两个整数N和M，1≤N，M≤1000。
 * <p>
 * 接下来N行，每行包含M个整数，第i行的第j个整数表示Ai,j。
 * <p>
 * 输出
 * 输出表面积的大小。
 * <p>
 * <p>
 * 样例输入
 * 2 2
 * 2 1
 * 1 1
 * 样例输出
 * 20
 */
public class 表面积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        n = sc.nextInt();
        m = sc.nextInt();
        long[][] square = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                square[i][j] = sc.nextLong();
            }
        }
//        m = 2;
//        n = 2;
//        int[][] square = {{2, 1}, {1, 1}};
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, square[i][j]);
            }
            sum = sum + max * 2;
        }
        for (int i = 0; i < m; i++) {
            long max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, square[j][i]);
            }
            sum = sum + max * 2;
        }
        sum = sum + n * m * 2;
        System.out.println(sum);
    }
}
