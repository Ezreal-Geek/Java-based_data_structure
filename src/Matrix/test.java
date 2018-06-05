package Matrix;

public class test {
    public static void main(String[] args) {
        System.out.println("-----待测试矩阵-----");
        int[][] mata0 = {
                {9, 0, 0, 0},
                {4, 5, 0, 0},
                {2, 2, 3, 0},
                {2, 0, 2, 1}};
        int[][] mata1 = {
                {9, 0, 0, 0},
                {4, 5, 0, 0},
                {2, 2, 3, 0},
                {2, 0, 2, 1}};
        int[][] mata2 = {
                {9, 4, 2, 2},
                {4, 5, 2, 0},
                {2, 2, 3, 2},
                {2, 0, 2, 1}};
        int[][] mata3 = {
                {2, 4, 2, 2},
                {4, 5, 2, 0},};
        int[][] mata4 = {
                {3, 4, 2,},
                {4, 5, 2,},
                {2, 2, 3,},
                {2, 0, 2,}};
        Matrix matrixA = new Matrix(4, 4, mata1);
        Matrix matrixa = new Matrix(4, 4, mata1);
        Matrix matrixB = new Matrix(4, 4, mata2);
        Matrix matrixC = new Matrix(2, 4, mata3);
        Matrix matrixD = new Matrix(4, 3, mata4);
        System.out.println(matrixA.toString("A"));
        System.out.println(matrixa.toString("a"));
        System.out.println(matrixB.toString("B"));
        System.out.println(matrixC.toString("C"));
        System.out.println(matrixD.toString("D"));


        System.out.println("-----测试矩阵相等-----");
        System.out.println("matrixA.equals(matrixa),return " + matrixA.equals(matrixa));
        System.out.println("matrixA.equals(matrixB),return " + matrixA.equals(matrixB));
        System.out.println("");

        System.out.println("-----测试判断三角矩阵-----");
        System.out.println("matrixa.isUpTriangular(),return " + matrixa.isUpTriangular());
        System.out.println("matrixa.isDownTriangular(),return " + matrixa.isDownTriangular());
        System.out.println("");

        System.out.println("-----测试判断矩阵对称-----");
        System.out.println("matrixB.isSymmetric(),return " + matrixB.isSymmetric());
        System.out.println("");

        System.out.println("-----测试矩阵乘法-----");
        System.out.println("matrixC.multi(matrixD).toString(\"C\")" + matrixC.multi(matrixD).toString("C"));

        System.out.println("-----测试判断矩阵鞍点-----");
        System.out.println("matrixC.saddlePoint(),return " + matrixC.saddlePoint());
        System.out.println("matrixD.saddlePoint(),return " + matrixD.saddlePoint());
        System.out.println("");

    }
}
