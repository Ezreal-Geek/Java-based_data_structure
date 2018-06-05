package graph;

/**
 * @author Ezreal
 * @Description: TODO
 * @created 2018/5/6 23:08
 * @Version 1.0
 **/

public class Matrix {
    private int rows, columns;
    private int[][] element;

    //Constructor
    public Matrix(int m, int n) {
        this.element = new int[m][n];
        this.rows = m;
        this.columns = n;
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix(int m, int n, int[][] values) {
        this(m, n);
        // values元素数量不一定满足 m*n
        for (int x = 0; x < m && x < values.length; x++) {
            for (int y = 0; y < n && y < values[x].length; y++) {
                this.element[x][y] = values[x][y];
            }
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getValue(int m, int n) {
        return this.element[m][n];
    }

    public void set(int m, int n, int value) {
        this.element[m][n] = value;
    }

    public String toString(String string) {
        String str = string + "(" + this.rows + "×" + this.columns + "):" + "\n";
        for (int x = 0; x < this.rows; x++) {
            for (int y = 0; y < this.columns; y++) {
                str += String.format("%5d", this.element[x][y]);
            }
            str += "\n";
        }
        return str;
    }

    public void setRowsColumns(int m, int n) {
        if (m > 0 && n > 0) {
            if (m > this.element.length || n > this.element[0].length) {
                int[][] source = this.element;
                this.element = new int[m][n];
                for (int i = 0; i < this.rows; i++) {
                    for (int j = 0; i < this.rows; i++) {
                        this.element[i][j] = source[i][j];
                    }
                }
                this.rows = m;
                this.columns = n;
            } else {
                throw new IllegalArgumentException("矩阵行列数不能小于零");
            }
        }
    }
}
