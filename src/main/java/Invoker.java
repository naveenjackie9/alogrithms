import edu.navi.bfs.GraphBFS;
import edu.navi.dfs.GraphDFS;
import edu.navi.djikstra.Djikstra;

import java.util.Scanner;

public class Invoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the alorithm you want to test");
        String algorithmType = scanner.nextLine();
        switch (algorithmType){
            case "BFS":
                    testBFS();
                    break;

            case "DFS":
                testDFS();
                break;

            case "DJIKSTRA":
                 testDjikstra();
                 break;
            default:
                    System.out.println("Alogrithm not available yet");
                    break;

        }
    }


    private static void testBFS() {
        GraphBFS graph = new GraphBFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 3);
        graph.bfs(0);

    }

    private static void testDFS() {
        GraphDFS graph = new GraphDFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 3);
        graph.dfs(0);

    }

    private static void testDjikstra(){
        Djikstra djikstra = new Djikstra(new char[]{'a', 'b', 'c', 'd', 'e', 'f'});
        djikstra.addDirectedEdge("a", "b", 2);
        djikstra.addDirectedEdge("a", "d", 8);
        djikstra.addDirectedEdge("b", "d", 5);
        djikstra.addDirectedEdge("b", "e", 6);
        djikstra.addDirectedEdge("d", "e", 3);
        djikstra.addDirectedEdge("d", "f", 2);
        djikstra.addDirectedEdge("e", "f", 1);
        djikstra.addDirectedEdge("e", "c", 9);
        djikstra.addDirectedEdge("f", "c", 3);
        djikstra.findMinimumDistance("a", "c");
    }
}
