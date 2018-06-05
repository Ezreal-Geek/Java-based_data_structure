package MultiArray;

/**
 * @author Ezreal
 * @Description: 【实现稀疏矩阵三元组顺序存储结构的insert方法，
 * 不能插入0元素，插入完成后保证三元组顺序表的行优先顺序】，
 * 【实现在三元组顺序存储结构上的矩阵转置运算】
 * @created 2018/5/7 19:22
 * @Version 1.0
 **/

public class Triple implements Comparable<Triple> {
    int rows, columns, value;

    public Triple(int row, int column, int value) {
        if (rows >= 0 && column >= 0) {
            this.rows = row;
            this.columns = column;
            this.value = value;
        } else {
            throw new IllegalArgumentException("行列号不能为负数");
        }
    }

    public Triple(Triple tri) {
        this(tri.rows, tri.columns, tri.value);
    }

    // 比较三元组次序的前后
    public int compareTo(Triple tri) {
        if (this.rows == tri.rows && this.columns == tri.columns) {
            return 0;
        }
        return (this.rows < tri.rows || this.rows == tri.rows && this.columns < tri.columns) ? -1 : 1;
    }

    public boolean equals(Triple tri) {
        return this.rows == tri.rows && this.columns == tri.columns && this.value == tri.value;
    }

    public String toString() {
        return "(" + rows + ", " + columns + ", " + value + ")";
    }

    public Triple toSymmetry() {
        return new Triple(this.columns, this.rows, this.value);
    }

    public Triple add(Triple triple) {
        if (this.rows != triple.rows || this.columns != triple.columns) {
            throw new IllegalArgumentException("无法相加");
        }
        this.value += triple.value;
        return this;
    }

    public void set(int row, int col, int val) {
        this.rows = row;
        this.columns = col;
        this.value = val;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public int getValue() {
        return this.value;
    }

}
