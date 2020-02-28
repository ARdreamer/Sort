package leetcode.搜索.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/perfect-squares/description/
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * 可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。
 * <p>
 * 要求解最小的平方数数量，就是求解从节点 n 到节点 0 的最短路径。
 * <p>
 * 本题也可以用动态规划求解，在之后动态规划部分中会再次出现。
 */
public class B组成整数的最小平方数数量 {
    public int numSquares(int n) {
        if (n <= 0) {
            return -1;
        }
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int i : squares) {
                    int q = cur - i;
                    if (q < 0)
                        break;
                    if (q == 0)
                        return level;
                    if (marked[q])
                        continue;
                    marked[q] = true;
                    queue.add(q);
                }
            }
        }
        return -1;
    }

    /**
     * 生成小于 n 的平方数序列
     *
     * @return 1, 4, 9, ...
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
//level 1
//
//13
//
//12 9 4
//
//level 2
//
//11 8 3
//8 5 0
//
//return 2

}
