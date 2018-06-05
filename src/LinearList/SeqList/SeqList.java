package LinearList.SeqList;

public class SeqList<T extends Comparable<? super T>> extends Object {

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

    public void showAll() {
        for (int i = 0; i < n; i++) {
            System.out.print(element[i]
            );
            System.out.print('\t');
        }
        System.out.print('\n');
    }

    public void removeAll(T key) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (this.element[i] == key) {
                for (int m = i; m < n - 1; m++) {
                    this.element[m] = this.element[m + 1];
                }
                found = true;
                this.n -= 1;
                i--;
            }
        }
        if (!found) {
            System.out.println("Error!" + key + " Not Found!");
        }
    }

    public void replaceFirst(T key, T x) {
        boolean found = false;
        first:
        for (int i = 0; i < n; i++) {
            if (this.element[i] == key) {
                this.element[i] = x;
                found = true;
                break first;
            }
        }
        if (!found) {
            System.out.println("Error!" + key + " Not Found!");
        }
    }

    public void replaceAll(T key, T x) {
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (this.element[i] == key) {
                this.element[i] = x;
                found = true;
            }
        }
        if (!found) {
            System.out.println("Error!" + key + " Not Found!");
        }
    }

    public int searchLast(T key) {
        int last = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (this.element[i] == key) {
                last = i;
                found = true;
            }
        }
        if (found) {
            return last;
        }
        return -1;
    }

    public void removeLast(T key) {
        int last = searchLast(key);
        if (last != -1) {
            for (int i = last; i < n - 1; i++) {
                this.element[i] = this.element[i + 1];
            }
            this.n -= 1;
        } else {
            System.out.println("Error!" + key + " Not Found!");
        }
    }

    public void replaceLast(T key, T x) {
        int last = searchLast(key);
        if (last != -1) {
            this.element[last] = x;
        } else {
            System.out.println("Error!" + key + " Not Found!");
        }
    }

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


}


