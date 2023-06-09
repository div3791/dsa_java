import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    public boolean isBipartite(int[][] graph) {

        int[] colored = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            colored[i] = -1;

        for (int i = 0; i < graph.length; i++) {
            if (colored[i] == -1) {
                boolean temp = bfs(i, graph, colored);
                if (temp == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int node, int[][] graph, int[] colored) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        colored[node] = 0;

        while (!queue.isEmpty()) {
            int item = queue.peek();
            queue.remove();

            for (int i : graph[item]) {
                if (colored[i] == -1) {
                    colored[i] = 1 - colored[item];
                    queue.add(i);
                } else if (colored[i] == colored[item]) {
                    return false;
                }
            }
        }

        return true;
    }

}
