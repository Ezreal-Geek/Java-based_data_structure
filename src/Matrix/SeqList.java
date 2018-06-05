package Matrix;

import MultiArray.Triple;

public class SeqList<T> extends Object {
    protected Object[] element;
    protected int n;

    public SeqList(int length) {
        this.element = new Object[length];
        this.n = 0;
    }

    public SeqList() {
        this(64);
    }

    public SeqList(Object[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.element[i] = values[i];
        }
        this.n = values.length;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    // 在位置i插入x
    public int insert(int i, T x) {
        if (x == null) {
            throw new NullPointerException("x == null");
        }
        //先讨论i的情况
        if (i < 0) {
            i = 0;
        }
        // n是当前数量，length是既定容量
        if (i > this.n) {
            i = this.n;
        }

        boolean Bigger = false;     // 数组是否已扩容
        Object[] element2 = new Object[element.length];
        if (this.n == element.length) {
            element2 = new Object[element.length * 2];
            Bigger = true;
        }

        for (int k = 0; k < i; k++) {
            element2[k] = this.element[k];
        }
        Bigger = true;
        for (int z = i; z < n; z++) {
            element2[z + 1] = this.element[z];
        }
        element2[i] = x;
        if (Bigger) {
            this.element = element2;
        }
        this.n++;
        return i;
    }

    public int insert(T x) {
        return this.insert(this.n, x);
    }

    public int insert(int m, int n, int value) {
        if (value == 0) {
            throw new IllegalArgumentException("不能插入零");
        }
        int i;
        Triple tri = new Triple(m, n, value);
        for (i = 0; i < this.element.length; i++) {
            if (tri.compareTo((Triple) element[i]) == -1) {
                /*for (int u = element.length; u > i; --u){
                    element[u] = element[u - 1];
                }
                element[i] = tri;*/
                insert(i, (T) tri);
                break;
            }
        }
        return i;
    }

    public int size() {
        return n;
    }

    public T get(int i) {
        if (i >= 0 && i < this.n) {
            return (T) this.element[i];
        }
        return null;
    }

    public void set(int i, T x) {
        /*if (x == null){
            throw new NullPointerException("x == null");
        }*/
        this.element[i] = x;
    }

    public T remove(int i) {
        if (this.n > 0 && i >= 0 && i < this.n) {
            T old = (T) this.element[i];
            for (int j = i; j < this.n - 1; j++) {
                this.element[j] = this.element[j + 1];
            }
            this.element[this.n - 1] = null;
            this.n--;
            return old;
        }
        ;
        return null;
    }

    public void showAll() {
        for (int i = 0; i < n; i++) {
            System.out.print(element[i]
            );
            System.out.print('\t');
        }
        System.out.print('\n');
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < this.n; i++) {
            // System.out.print(this.element[i]);
            str = str + this.element[i] + " ";
        }
        return str + "\b]";
    }
}
