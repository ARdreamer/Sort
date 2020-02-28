package test.graph;

//稀疏图 - 邻接表
public class SparseGraph {
    private int n;//顶点数
    private int m;//边数
    private boolean directed;
    private int[][] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.m = 0;
        g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = 0;
            }
        }
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        g[v][w] = w;
        if (v != w && !directed) {//如果是无向图
            g[w][v] = v;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        for (int i = 0; i < g[v].length; i++) {
            if (g[v][i] == w) {
                return true;
            }
        }
        return false;
    }
}
