package graph;

/**
 * @author Ezreal
 * @Description: TODO
 * @created 2018/6/4 19:28
 * @Version 1.0
 **/

public class MatrixGraph<T> extends AbstractGraph {
    protected Matrix matrix;

    public MatrixGraph(int length) {
        super(length);
        this.matrix = new Matrix(length);
    }

    public MatrixGraph() {
        this(10);
    }

    public MatrixGraph(T[] vertexes) {
        this(vertexes.length);
        for (int i = 0; i < vertexes.length; i++) {
            this.insertVertex(vertexes[i]);
        }
    }

    public MatrixGraph(T[] vertexes, Triple[] edges) {
        this(vertexes);
        for (int j = 0; j < edges.length; j++) {
            this.insertEdge(edges[j]);
        }
    }

    public String toString() {
        String str = super.toString() + "邻接矩阵： \n";
        int n = this.vertexCount();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.matrix.getValue(i, j) == MAX_WEIGHT) {
                    str += "    ∞";
                } else {
                    str += String.format("%6d", this.matrix.getValue(i, j));
                }
            }
            str += "\n";
        }
        return str;
    }

    public int weight(int i, int j) {
        return this.matrix.getValue(i, j);
    }

    protected int next(int i, int j) {
        int n = this.vertexCount();
        if (i >= 0 && i < n && j >= -1 && i != j) {
            for (int k = j + 1; k < n; k++) {
                if (this.matrix.getValue(i, k) > 0 && this.matrix.getValue(i, k) < MAX_WEIGHT) {
                    return k;
                }
            }
        }
        return -1;
    }

    @Override
    public int insertVertex(Object x) {
        int i = this.vertexlist.insert(x);
        if (i >= this.matrix.getColumns()) {
            this.matrix.setRowsColumns(i + 1, i + 1);
        }
        for (int j = 0; j < i; j++) {
            this.matrix.set(i, j, MAX_WEIGHT);
            this.matrix.set(j, i, MAX_WEIGHT);
        }
        return i;
    }

    public void insertEdge(int i, int j, int weight) {
        if (i != j) {
            if (weight <= 0 || weight > MAX_WEIGHT) {
                weight = MAX_WEIGHT;
            }
            this.matrix.set(i, j, weight);
        } else {
            throw new IllegalArgumentException("不能插入自身环，i = " + i + "，j =" + j);
        }
    }

    public void insertEdge(Triple edge) {
        this.insertEdge(edge.row, edge.column, edge.value);
    }


    @Override
    public void removeVertex(Object x) {

    }

    public int degree(int i) {
        int count = 0;
        for (int n = 0; n < this.vertexlist.size(); n++) {
            if (this.matrix.getValue(n, i) != MAX_WEIGHT) {
                count++;
            }
        }
        return count - 1;
    }

    public int edgeCount() {
        int count = 0;
        int N = 1;
        for (int m = N; m < this.vertexlist.size(); m++) {
            for (int n = 0; n < this.vertexlist.size() - 1; n++) {
                if (this.matrix.getValue(m, n) != MAX_WEIGHT) {
                    count++;
                }
            }
            N++;
        }
        return count - this.vertexlist.size();
    }

}
