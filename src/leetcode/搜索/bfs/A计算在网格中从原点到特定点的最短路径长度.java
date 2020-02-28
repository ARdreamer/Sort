package leetcode.搜索.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [[1,1,0,1],
 * [1,0,1,0],
 * [1,1,1,1],
 * [1,0,1,1]]
 * 题目描述：1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
public class A计算在网格中从原点到特定点的最短路径长度 {

    class demo<k, v> {
        k key;
        v value;

        public demo(k k, v v) {
            this.key = k;
            this.value = v;
        }
    }

    final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minPathLength(int[][] grids, int tr, int tc) {
        if (grids == null || grids.length == 0 || grids[0] == null || grids[0].length == 0)
            return -1;
        int m = grids.length;
        int n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int path = 0;
        queue.add(new Pair<>(0, 0));
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey();
                int cc = cur.getValue();
                grids[cr][cc] = 0;
                for (int[] d : dir) {
                    int nr = cr + d[0];
                    int nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 0)
                        continue;
                    if (nr == tr && nc == tc)
                        return path;
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

    public int serach(int[][] grids, int tr, int tc) {
        if (grids == null || grids.length == 0 || grids[0] == null || grids[0].length == 0)
            return -1;
        int m = grids.length;
        int n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int path = 0;
        queue.add(new Pair<>(0, 0));
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            while (size-- > 0) {

            }

        }
        return -1;
    }
}
