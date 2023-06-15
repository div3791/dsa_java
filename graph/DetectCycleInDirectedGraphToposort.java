import java.util.*;

public class DetectCycleInDirectedGraphToposort {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
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
            int item = queue.peek();
            queue.remove();
            i++;
            for (int j : adj.get(item)) {
                indegrees[j]--;
                if (indegrees[j] == 0) {
                    queue.add(j);
                }
            }
        }

        return i != V;
    }
}
