package graph;

/**
 * @author Ezreal
 * @Description: TODO
 * @created 2018/6/4 19:28
 * @Version 1.0
 **/

public class Triple implements Comparable<Triple> {
    int row, column, value;

    public Triple(int m, int n, int value) {
        this.row = m;
        this.column = n;
        this.value = value;
    }

    public int compareTo(Triple tri) {
        if (this.row == tri.row && this.column == tri.column) {
            return 0;
        }
        return (this.row < tri.row || this.row == tri.row && this.column < tri.column) ? -1 : 1;
    }

    public String toString() {
        return value + "";
    }
}
