package MultiArray;

/**
 * @author Ezreal
 * @Description: TODO
 * @created 2018/5/7 0:24
 * @Version 1.0
 **/

public class test {
    public static void main(String[] args) {
        Triple[] elemsa = {
                new Triple(0, 2, 11), new Triple(0, 4, 17),
                new Triple(1, 1, 20), new Triple(3, 0, 19),
                new Triple(3, 5, 28), new Triple(4, 4, 50)};
        SeqSparseMatrix smata = new SeqSparseMatrix(5, 6, elemsa);
        System.out.println("A " + smata.toString("A"));
        System.out.println("----------插入三元组(0, 3, 12)------------");
        smata.st.insert(0, 3, 12);
        System.out.print("B " + smata.toString("B"));
        System.out.println("----------对矩阵B进行转置---------");
        System.out.println("C" + smata.transpose().toString("C"));
        /*smata.set(0, 3, 99);
        System.out.println(smata.toString("D"));*/
        System.out.println("----------矩阵相加---------");
        SeqSparseMatrix smata2 = new SeqSparseMatrix(5, 6, elemsa);
        smata.add(smata2);
        System.out.println(smata.toString("A"));
    }
}
