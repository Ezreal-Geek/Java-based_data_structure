package tree;

public class BinaryTrees {
    private static int i = 0;

    public static BinaryTree<String> createByGenList(String genlist) {
        BinaryTree<String> bitree = new BinaryTree<String>();
        i = 0;
        if (genlist.length() > 0) {
            bitree.root = create(genlist);
        }
        return bitree;
    }

    public static BinaryNode<String> create(String genlist) {
        BinaryNode<String> p = null;
        char ch = genlist.charAt(i);
        if (ch == '^') {
            i++;
            return null;
        }
        int end = i;
        while (end < genlist.length() && ch != '(' && ch != ',' && ch != ')') {
            end++;
            ch = genlist.charAt(end);
        }
        String str = genlist.substring(i, end);
        i = end;
        p = new BinaryNode<String>(str);
        if (genlist.charAt(i) == '(') {
            i++;
            p.left = create(genlist);
            i++;
            p.right = create(genlist);
            i++;
        }
        return p;
    }
}
