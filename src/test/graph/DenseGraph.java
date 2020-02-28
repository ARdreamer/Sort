package test.graph;

//稠密图- 邻接表
public class DenseGraph {
    private int n;//顶点数
    private int m;//边数
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        this.m = 0;
        g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = false;
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
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {//如果是无向图
            g[w][v] = true;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        return g[v][w];
    }
}
