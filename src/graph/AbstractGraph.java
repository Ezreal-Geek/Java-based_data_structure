package graph;

/**
 * @author Ezreal
 * @Description: 表示顶点集合的抽象图类
 * @created 2018/5/31 15:35
 * @Version 1.0
 **/

public abstract class AbstractGraph<T> {
    protected static final int MAX_WEIGHT = 0X0000ffff;
    protected SeqList<T> vertexlist;

    public AbstractGraph(int length) {
        this.vertexlist = new SeqList<T>(length);
    }

    public AbstractGraph() {
        this(10);
    }

    public int vertexCount() {
        return this.vertexlist.size();
    }

    public String toString() {
        return "顶点集合：" + this.vertexlist.toString() + "\n";
    }

    public T getVertex(int i) {
        return this.vertexlist.get(i);
    }

    public void setVertex(int i, T x) {
        this.vertexlist.set(i, x);
    }

    public abstract int insertVertex(T x);

    public abstract void removeVertex(T x);

    protected abstract int next(int i, int j);

    public abstract int weight(int i, int j);

    public void DFSTraverse(int i) {
        boolean[] visited = new boolean[this.vertexCount()];
        int j = i;
        do {
            if (!visited[j]) {
                System.out.print("{");
                this.depthfs(j, visited);
                System.out.print("}");
            }
            j = (j + i) % this.vertexCount();
        } while (j != i);
        System.out.println();
    }
    private void depthfs(int i, boolean[] visited) {
        System.out.print(this.getVertex(i) + " ");
        visited[i] = true;
        int j = this.next(i, -1);
        while (j != -1) {
            if (!visited[j]) {
                depthfs(j, visited);
            }
            j = this.next(i, j);
        }
    }

    public void minSpanTree() {
        Triple[] mst = new Triple[vertexCount() - 1];
        for (int i = 0; i < mst.length; i++) {
            mst[i] = new Triple(0, i + 1, this.weight(0, i + 1));
        }
        for (int i = 0; i < mst.length; i++) {
            int minweight = mst[i].value;
            int min = i;
            for (int j = i + 1; j < mst.length; j++) {
                if (mst[j].value < minweight) {
                    minweight = mst[j].value;
                    min = j;
                }
            }

            Triple edge = mst[min];
            mst[min] = mst[i];
            mst[i] = edge;
            int tv = edge.column;
            for (int j = i + 1; j < mst.length; j++) {
                int v = mst[j].column;
                int weight = this.weight(tv, v);
                if (weight < mst[j].value) {
                    mst[j] = new Triple(tv, v, weight);
                }
            }
        }
        System.out.print("\n最小生成树的边集合：");
        int mincost = 0;
        for (int i = 0; i < mst.length; i++) {
            System.out.print(mst[i] + " ");
            mincost += mst[i].value;
        }
        System.out.println("，最小代价为" + mincost);
    }

    public void shortestPath(int i) {
        int n = this.vertexCount();
        boolean[] vset = new boolean[n];
        vset[i] = true;
        int[] dist = new int[n];
        int[] path = new int[n];
        for (int j = 0; j < n; j++) {
            dist[j] = this.weight(i, j);
            path[j] = (j != 1 && dist[j] < MAX_WEIGHT) ? i : -1;
        }
        for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
            int mindist = MAX_WEIGHT;
            int min = 0;
            for (int k = 0; k < n; k++) {
                if (!vset[k] && dist[k] < mindist) {
                    mindist = dist[k];
                    min = k;
                }
            }
            if (mindist == MAX_WEIGHT) {
                break;
            }
            vset[min] = true;
            for (int k = 0; k < n; k++) {
                if (!vset[k] && this.weight(min, k) < MAX_WEIGHT &&
                        dist[min] + this.weight(min, k) < dist[k]) {
                    dist[k] = dist[min] + this.weight(min, k);
                    path[k] = min;
                }
            }
        }
        System.out.print(this.getVertex(i) + "顶点的单源最短路径：");
        for (int j = 0; j < n; j++) {
            if (j != i) {
                SinglyList<T> pathlink = new SinglyList<T>();
                pathlink.insert(0, this.getVertex(j));
                for (int k = path[j]; k != i && k != j && k != -1; k = path[k]) {
                    pathlink.insert(0, this.getVertex(k));
                }
                pathlink.insert(0, this.getVertex(i));
                System.out.print(pathlink.toString() + "长度" + (dist[j] == MAX_WEIGHT ? "∞" : dist[j]) + ",\n");
            }
        }
        System.out.println();
    }

}
