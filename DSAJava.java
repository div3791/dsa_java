import java.util.List;

public class DSAJava {
    public static void main(String[] args) {

        ShortestPathInUndirected shortestPathInUndirected = new ShortestPathInUndirected();

        int n = 5;
        int m = 6;
        int[][] edges = {
                { 1, 2, 2 },
                { 2, 5, 5 },
                { 2, 3, 4 },
                { 1, 4, 1 },
                { 4, 3, 3 },
                { 3, 5, 1 },
        };

        // case 2
        // n = 3;
        // m = 1;
        // int[][] edges = { { 1, 2, 1 } };

        List<Integer> path = shortestPathInUndirected.printShortestPath(n, m, edges);
        System.out.println(path);
    }
}
