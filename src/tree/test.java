package tree;

/**
 * @author Ezreal
 * @Description: TODO
 * @created 2018/5/31 21:39
 * @Version 1.0
 **/

public class test {
    public static void main(String[] args) {
        System.out.println("------------进行二叉树非递归中序遍历测试-----------");
        System.out.println("该二叉树的广义表表示为：A(B(D(^,G),^),C(E,F(H,^)))");
        String genlist = "A(B(D(^,G),^),C(E,F(H,^)))";
        BinaryTree<String> bitree = BinaryTrees.createByGenList(genlist);
        bitree.inorderNRe(bitree.root);
        System.out.println();

        System.out.println("------------进行线索二叉树inPrev()方法测试-----------");
        String[] prelist = {"A", "B", "D", "H", null, null, null, "E", null, null, "C", "F", null, null, "G"};
        ThreadBinaryTree<String> tb = new ThreadBinaryTree<String>(prelist);
        System.out.println("根结点的上一个结点是：" + tb.inPrev(tb.root).data.toString());
        System.out.println();

        System.out.println("------------进行二叉树输出叶子结点测试-----------");
        bitree.linkedLeaves(bitree.root);
        System.out.println();

    }
}
