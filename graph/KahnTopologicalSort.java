import java.util.*;

public class KahnTopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] ans = new int[V];
        int[] indegrees = new int[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                indegrees[j]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int i = 0;

        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();

            ans[i++] = node;

            for (int j : adj.get(node)) {
                indegrees[j]--;
                if (indegrees[j] == 0) {
                    queue.add(j);
                }
            }
        }

        return ans;
    }
}
