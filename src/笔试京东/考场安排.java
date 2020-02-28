package 笔试京东;

import java.util.*;

/**
 * ac 36
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 某校在积极推行无人监考制度，
 * 但是总有学生是不自觉的，
 * 如果将两个很熟的异性朋友放在同一个考场里，
 * 他们就会交流甚至作弊。因此一个考场中不能允许两个很熟的异性朋友存在，
 * 学校希望通过搬出一部分学生的方法来改善这一问题。
 * <p>
 * 但是又因为教室数量有限，因此希望一个教室中容下的学生尽可能多，即需要搬出教室的学生数量尽可能少，请你输出搬出教室人数最少，且字典序最小的方案。
 * <p>
 * 输入
 * 输入第一行有两个整数n和m，分别表示有n个男生和n个女生，有m个朋友关系。
 * <p>
 * (1<=n<=500,1<=m<=100000)
 * <p>
 * 接下来m行，每行有两个整数，x和y，表示第x号男生和第y号女生是朋友。男生的编号均为[1,n]，女生的编号为[n+1,2n]。
 * <p>
 * 输出
 * 输出第一行包含一个整数a，表示最少需要搬出教室的人数。
 * <p>
 * 输出第二行有a个整数，即a个需要搬出教室的人的编号，要求人数最少，且字典序最小。
 * <p>
 * <p>
 * 样例输入
 * 2 2
 * 3 1
 * 1 4
 * 样例输出
 * 1
 * 1
 */
public class 考场安排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] friends = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int f = sc.nextInt();
            int r = sc.nextInt();
//            System.out.println("f " + f + " r " + r);
            friends[f][(r - n)] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(friends[i][j] + " ");
            }
            System.out.println();
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int r = rows(friends, i, n);
            int q = 0;
            int max = 0;
            for (int j = 1; j <= n; j++) {
                int c = cols(friends, j, n);
                System.out.println("c\t" + c);
                if (max < c) {
                    max = c;
                    q = j;
                }
            }
            if (r >= max) {
                prRows(friends, i, n);
                if (list.contains(i)) {
                    continue;
                }
                list.add(i);
                count++;
            } else {
                prCols(friends, q, n);
                if (list.contains(q)) {
                    continue;
                }
                list.add(q + n);
                count++;
            }

        }
        System.out.println(count);
        Collections.sort(list);
        for (int i : list)
            System.out.println(i + " ");
    }

    public static int rows(int[][] nums, int i, int n) {
        int count = 0;
        for (int j = 1; j <= n; j++) {
            if (nums[i][j] == 1)
                count++;
        }
        return count;
    }

    public static void prRows(int[][] nums, int i, int n) {
        for (int j = 1; j <= n; j++)
            nums[i][j] = 0;
    }

    public static int cols(int[][] nums, int j, int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (nums[i][j] == 1)
                count++;
        }
        return count;
    }

    public static void prCols(int[][] nums, int j, int n) {
        for (int i = 1; i <= n; i++) {
            nums[i][j] = 0;
        }
    }
}
