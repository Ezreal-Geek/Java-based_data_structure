package graph;

/**
 * @author Ezreal
 * @Description: TODO
 * @created 2018/6/4 20:49
 * @Version 1.0
 **/

public class test {
    public static void main(String[] args) {
        String[] vertexes = {"A", "B", "C", "D", "E"};
        Triple[] edges = {
                new Triple(0, 1, 45), new Triple(0, 2, 28), new Triple(0, 3, 10),
                new Triple(1, 0, 45), new Triple(1, 2, 12), new Triple(1, 4, 21),
                new Triple(2, 0, 28), new Triple(2, 1, 12), new Triple(2, 3, 17), new Triple(2, 4, 26),
                new Triple(3, 0, 10), new Triple(3, 2, 17), new Triple(3, 4, 15),
                new Triple(4, 1, 21), new Triple(4, 2, 26), new Triple(4, 3, 15)
        };
        MatrixGraph<String> graph = new MatrixGraph<String>(vertexes, edges);
        Triple[] edges2 = {
                new Triple(0, 1, 45), new Triple(0, 3, 10),
                new Triple(1, 2, 12), new Triple(1, 4, 21),
                new Triple(2, 0, 28), new Triple(3, 4, 15)
        };
        MatrixGraph<String> graph2 = new MatrixGraph<String>(vertexes, edges2);

        System.out.println("带权无向图G3（除顶点F）， " + graph.toString());
        System.out.println("图的度数为：" + graph.degree(1));
        System.out.println("图的边数为：" + graph.edgeCount());
        graph.DFSTraverse(1);
        graph.minSpanTree();
        System.out.println();
        graph2.shortestPath(0);
    }

}
