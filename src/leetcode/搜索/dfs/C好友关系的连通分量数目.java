package leetcode.搜索.dfs;

/**
 * https://leetcode-cn.com/problems/friend-circles/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 * [
 * [1,0,0,1],
 * [0,1,1,0],
 * [0,1,1,1],
 * [1,0,1,1]
 * ]
 */
public class C好友关系的连通分量数目 {
    private int n;

    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }
}
