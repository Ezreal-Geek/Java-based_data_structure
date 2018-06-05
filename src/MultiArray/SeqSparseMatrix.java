package MultiArray;

public class SeqSparseMatrix {
    private int rows, columns;
    SeqList<Triple> st; //= new Seqst<Triple>();

    public SeqSparseMatrix(int m, int n) {
        if (m <= 0 || n <= 0)
            throw new IllegalArgumentException("矩阵行数或列数不能为数");
        this.rows = m;
        this.columns = n;
        this.st = new SeqList<Triple>();
        /*for (int i = 0; i < m; i++){
            this.st.insert(new Seqst<Triple>());
        }*/
    }

    public SeqSparseMatrix(int rows, int columns, Triple[] elems) {
        this(rows, columns);
        // 按行主序插入一个元素的三元组
        for (int i = 0; i < elems.length; i++) {
            // System.out.println(elems[i]);
            this.st.insert(elems[i]);
        }
    }

    public String toString(String string) {
        // 打印三元组顺序表
        String str = "三元组顺序表：" + this.st.toString() + "\n";

        // 打印矩阵
        str += string + "(" + rows + " × " + columns + "): \n";
        int k = 0;
        // 返回第k个元素，若k指定序号无效则返回null
        Triple elem = this.st.get(k++);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++)
                if (elem != null && i == elem.rows && j == elem.columns) {
                    str += String.format("%5d", elem.value);
                    elem = this.st.get(k++);
                } else {
                    str += String.format("%5d", 0);
                }
            str += "\n";
        }
        return str;
    }

    public void set(Triple elem) {
        this.set(elem.rows, elem.columns, elem.value);
    }

    public void set(int row, int column, int value) {
        // 不存储值为0元素
        if (value == 0)
            return;

        if (row >= this.rows || column >= this.columns)
            throw new IllegalArgumentException("三元组的行或列序号越界");

        Triple elem = new Triple(row, column, value);
        int i = 0;
        // 在排序的三元组顺序表中查找elem对象，或更改或插入
        while (i < this.st.size()) {
            Triple item = this.st.get(i);
            // 若elem存在，则更改改位置矩阵元素
            if (elem.compareTo(item) == 0) {
                // 设置顺序表第i个元素为elem
                this.st.set(i, elem);
                return;
            }

            // elem 较大时向后走
            if (elem.compareTo(item) >= 0)
                i++;
            else
                break;
        }
        this.st.insert(i, elem);
    }

    public SeqSparseMatrix transpose() {
        //构造零矩阵，指定行数和列数
        SeqSparseMatrix trans = new SeqSparseMatrix(columns, rows);
        for (int i = 0; i < this.st.size(); i++) {
            trans.set(this.st.get(i).toSymmetry());
            // trans.set(this.st.get(i).columns, this.st.get(i).rows, this.st.get(i).value);
        }
        return trans;
    }

    public void add(SeqSparseMatrix mat) {
        if (this.rows != mat.rows || this.columns != mat.columns) {
            throw new IllegalArgumentException("相加的两个矩阵，行、列数要分别相等");
        }
        for (int y = 0; y < mat.st.size(); y++) {
            this.st.insert("add", mat.st.get(y).getRows(), mat.st.get(y).getColumns(), mat.st.get(y).getValue());

        }
    }

}
