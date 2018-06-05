package tree;

public class ThreadBinaryTree<T> extends BinaryTrees {
    public ThreadNode<T> root;

    public ThreadBinaryTree(T[] prelist) {
        this.root = create(prelist);
        inorderThread(this.root);
    }

    private int i = 0;

    private ThreadNode<T> create(T[] prelist) {
        ThreadNode<T> p = null;
        if (i < prelist.length) {
            T elem = prelist[i];
            i++;
            if (elem != null) {
                p = new ThreadNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }

    private ThreadNode<T> front = null;

    private void inorderThread(ThreadNode<T> p) {
        if (p != null) {
            inorderThread(p.left);
            if (p.left == null) {
                p.ltag = true;
                p.left = front;
            }
            if (p.right == null) {
                p.rtag = true;
            }
            if (front != null && front.rtag) {
                front.right = p;
            }
            front = p;
            inorderThread(p.right);
        }
    }

    public void inorderNRe(ThreadNode<T> node) {
        SeqStack<ThreadNode> ss = new SeqStack<ThreadNode>();
        while (node != null || !ss.isEmpty()) {
            while (node != null) {
                ss.push(node);
                if (node.ltag) {
                    node = null;
                } else {
                    node = node.left;
                }
            }
            if (!ss.isEmpty()) {
                node = ss.pop();
                System.out.println(node.data.toString());
                if (node.rtag) {
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
    }

    public ThreadNode<T> inPrev(ThreadNode<T> p) {
        if (p.ltag) {
            return p.left;
        }
        p = p.left;
        while (!p.rtag) {
            p = p.right;
        }
        return p;
    }

    public ThreadNode<T> inNext(ThreadNode<T> p) {
        if (p.rtag) {
            return p.right;
        }
        p = p.right;
        while (!p.ltag) {
            p = p.left;
        }
        return p;
    }

}
