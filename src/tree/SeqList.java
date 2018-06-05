package tree;

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

        Object[] source = this.element;
        // 当n == length时，再插入一个，数组溢出
        if (this.n == element.length) {
            this.element = new Object[element.length * 2];
            for (int k = 0; k < i; k++) {
                this.element[k] = source[k];
            }
        }
        for (int z = i; z < n; z++) {
            this.element[z + 1] = source[z];
        }
        source[i] = x;
        this.n++;
        return i;
    }

    public int insert(T x) {
        return this.insert(this.n, x);
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
}
