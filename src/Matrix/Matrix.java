package Matrix;

/**
 * @author Ezreal
 * @Description: （1）public boolean equals(Matrix mat)		//比较矩阵是否相等
 * （2）public boolean isTriangular(boolean up) //判断矩阵是否为上/下三角矩阵，参数up为true表示判断是否为上三角
 * （3）public boolean isSymmetric()		//判断是否为对称矩阵
 * （4）public Matrix multi(Matrix mat) 	//返回与this与mat相乘后的矩阵，不改变this
 * （5）public int saddlePoint()			//返回矩阵的鞍点值
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

    public boolean equals(Matrix matr) {
        if (this.rows != matr.rows || this.columns != matr.columns) {
            return false;
        }
        boolean equal = true;
        flag:
        for (int x = 0; x < this.rows; x++) {
            for (int y = 0; y < this.columns; y++) {
                if (this.element[x][y] != matr.element[x][y]) {
                    equal = false;
                    break flag;
                }
            }
        }
        if (!equal) {
            return false;
        }
        return true;
    }

    public boolean isUpTriangular() {
        boolean up = true;
        flag:
        for (int x = 1; x < this.rows; x++) {
            for (int y = 1; y < x; y++) {
                if (this.element[x][y] != 0) {
                    up = false;
                    break flag;
                }
            }
        }
        return up;
    }

    public boolean isDownTriangular() {
        boolean down = true;
        flag:
        for (int x = 1; x < this.columns; x++) {
            for (int y = 1; y < x; y++) {
                if (this.element[y][x] != 0) {
                    down = false;
                    break flag;
                }
            }
        }
        return down;
    }

    public boolean isSymmetric() {
        boolean symm = true;
        flag:
        for (int x = 1; x < this.rows; x++) {
            for (int y = 1; y < x; y++) {
                if (this.element[x][y] != this.element[y][x]) {
                    symm = false;
                    break flag;
                }
            }
        }
        return symm;
    }

    //返回与this与mat相乘后的矩阵，不改变this
    public Matrix multi(Matrix mat) {
        if (this.columns != mat.rows) {
            throw new IllegalArgumentException("这两个矩阵不符合相乘规则");
        }
        Matrix mat_mul = new Matrix(this.rows, mat.columns);
        for (int x = 0; x < this.rows; x++) {
            for (int z = 0; z < mat.columns; z++) {
                int value = 0;
                for (int y = 0; y < this.columns; y++) {
                    value += (this.element[x][y] * mat.element[y][z]);
                }
                mat_mul.element[x][z] = value;
            }

        }
        return mat_mul;
    }

    public boolean isMaxInARow(int m, int n) {
        boolean is_max = true;
        int max = this.element[m][n];
        flag:
        for (int i = 0; i < this.columns; i++) {
            if (this.element[m][i] > this.element[m][n]) {
                is_max = false;
                break flag;
            }
        }
        return is_max;
    }

    public boolean isMinInAColumn(int m, int n) {
        boolean is_min = true;
        int min = this.element[m][n];
        flag:
        for (int i = 0; i < this.rows; i++) {
            if (this.element[i][n] < this.element[m][n]) {
                is_min = false;
                break flag;
            }
        }
        return is_min;
    }

    public String saddlePoint() {
        int m = 0;
        int n = 0;
        int num = 0;
        for (int x = 0; x < this.rows; x++) {
            for (int y = 0; y < this.columns; y++) {
                if (isMaxInARow(x, y) && isMinInAColumn(x, y)) {
                    m = x;
                    n = y;
                    num++;
                }
            }
        }
        if (num == 1) {
            return "鞍点是:(" + m + "," + n + ")" + this.element[m][n];
        }
        return "鞍点不存在";
    }
}
