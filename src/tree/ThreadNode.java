package tree;

public class ThreadNode<T> {
    public T data;
    public ThreadNode<T> left, right;
    public boolean ltag, rtag;

    public ThreadNode(T data, ThreadNode<T> left, boolean ltag, ThreadNode<T> right, boolean rtag) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.ltag = ltag;
        this.rtag = rtag;
    }

    public ThreadNode(T data) {
        this(data, null, false, null, false);
    }

    public String toString() {
        return data.toString();
    }

    public boolean isLeaf() {
        return this.ltag && this.rtag;
    }

}
