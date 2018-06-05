package tree;


/**
 * @author Ezreal
 * @Description: TODO
 * @created 2018/5/22 14:15
 * @Version 1.0
 **/

public class BinaryTree<T> {
    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public BinaryNode<T> insert(T x) {
        return this.root = new BinaryNode<T>(x, this.root, null);
    }

    public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild) {
        if (x == null) {
            return null;
        }
        if (leftChild) {
            return parent.left = new BinaryNode<T>(x, parent.left, null);
        }
        return parent.right = new BinaryNode<T>(x, null, parent.right);

    }

    public void remove(BinaryNode<T> parent, boolean leftChild) {
        if (leftChild) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    public void clear() {
        this.root = null;
    }

    // 递归先序遍历
    public void preorder(BinaryNode<T> p) {
        if (p != null) {
            System.out.print(p.data.toString() + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void preorderRe() {
        preorder(this.root);
        System.out.println();
    }

    // 非递归先序遍历
    public void preorderNRe(BinaryNode<T> node) {
        SeqStack<BinaryNode> ss = new SeqStack<BinaryNode>();
        while (node != null || !ss.isEmpty()) {
            while (node != null) {
                System.out.println(node.data.toString());
                ss.push(node);
                node = node.left;
            }
            if (!ss.isEmpty()) {
                node = ss.pop();
                node = ss.pop();
                node = node.right;
            }
        }
    }

    public void inorderNRe(BinaryNode<T> node) {
        System.out.print("该二叉树的非递归中序遍历输出为：");
        SeqStack<BinaryNode> ss = new SeqStack<BinaryNode>();
        while (node != null || !ss.isEmpty()) {
            while (node != null) {
                ss.push(node);
                node = node.left;
            }
            if (!ss.isEmpty()) {
                node = ss.pop();
                System.out.print("\t" + node.data.toString());
                node = node.right;
            }
        }
        System.out.println();
    }

    public void printGenList() {
        System.out.print("二叉树的广义表表示：");
        printGenList(this.root);
        System.out.println();
    }

    public void printGenList(BinaryNode<T> p) {
        if (p == null) {
            System.out.print("^");
        } else {
            System.out.print(p.data.toString() + "");
            if (p.left != null || p.right != null) {
                System.out.print("(");
                printGenList(p.left);
                System.out.print(",");
                printGenList(p.right);
                System.out.print(")");
            }
        }
    }

    public SinglyList<BinaryNode> linkedLeaves(BinaryNode node) {
        System.out.print("叶子结点为：");
        SinglyList<BinaryNode> sl = new SinglyList<>();
        SeqStack<BinaryNode> ss = new SeqStack<BinaryNode>();

        BinaryNode front = null;
        while (node != null || !ss.isEmpty()) {
            while (node != null) {
                ss.push(node);
                node = node.left;
            }
            if (!ss.isEmpty()) {
                node = ss.pop();
                if (node.isLeaf()) {
                    sl.insert(node);
                    System.out.print(node.data.toString() + "\t");
                }
                node = node.right;
            }
        }
        return sl;
    }


}
