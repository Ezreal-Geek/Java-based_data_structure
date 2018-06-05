package tree;

/**
 * @author Ezreal
 * @Description: TODO
 * @created 2018/5/22 11:38
 * @Version 1.0
 **/

public class BinaryNode<T> {
    public T data;
    public BinaryNode<T> left, right;

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public String toString() {
        return this.data.toString();
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
