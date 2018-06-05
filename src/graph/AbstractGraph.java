package graph;

import tree.SeqList;

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
}
