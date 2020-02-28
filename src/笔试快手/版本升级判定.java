package 笔试快手;

import java.util.Scanner;

/**
 * 时间限制：C/C++ 2秒，其他语言 4秒
 * 空间限制：C/C++ 32768K，其他语言 65536K
 * 64bit IO Format: %lld
 * 本题可使用本地IDE编码，不做跳出限制，编码后请点击“保存并调试”按钮进行代码提交。
 * 题目描述
 * 给定两个版本号，只有在版本号更高的时候，才可以升级。「.」号作为分割符使用，版本号中只有数和.号。
 * <p>
 * 例如：0.1<1.1
 * 1.2<13.37
 * <p>
 * 输入描述:
 * 第一行为m(1<=m<=100000)，表示测试组数，接下来m行，表示m次查询。
 * <p>
 * 每行两个版本号，空格分隔。一个版本号中最多只会出现3个「.」。每个版本号中数字1<=x<=100。
 * 输出描述:
 * 对于每一次查询，输出是否可以升级，是则输出"true"，否则输出"false" (引号不要输出)
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * 2
 * 6.6.6 6.6.7
 * 1 1.0
 * 输出
 * 复制
 * true
 * false
 * 说明
 * 1和1.0被认为是相同的版本号
 * 示例2输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * 1
 * 1 1.0.0.2
 * 输出
 * 复制
 * true
 */
public class 版本升级判定 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        boolean[] booleans = new boolean[m];
        int index = 0;
        while (m-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();
            String[] s1 = str1.split("\\.");
            String[] s2 = str2.split("\\.");
            int[] i1 = new int[s1.length];
            int[] i2 = new int[s2.length];
            for (int i = 0; i < i1.length; i++) {
                i1[i] = Integer.parseInt(s1[i]);
            }
            for (int i = 0; i < i2.length; i++) {
                i2[i] = Integer.parseInt(s2[i]);
            }
            int l1 = s1.length;
            int l2 = s2.length;
            int len = Math.max(l1, l2);
            boolean flag = false;
            for (int i = 0; i < len; i++) {
                int j = (i < l1 ? i1[i] : 0);
                int k = (i < l2 ? i2[i] : 0);
                if (j < k) {
                    System.out.println("true");
                    flag = true;
                } else if (j > k) {
                    System.out.println("false");
                    flag = true;
                }
            }
            if (!flag){
                System.out.println("false");
            }
        }
    }
}
