import java.util.*;

public class ShortestPathInDAG {
    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Pair<Integer, Integer>>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            graph.get(u).add(new Pair<Integer, Integer>(v, wt));
        }

        boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topoSort(i, visited, graph, stack);
            }
        }

        int distances[] = new int[N];
        for (int i = 0; i < N; i++) {
            distances[i] = (int) 1e9;
        }

        // select starting point or root node from where distance to be calculated
        distances[0] = 0;

        while (!stack.isEmpty()) {
            int item = stack.peek();
            stack.pop();
            for (int i = 0; i < graph.get(item).size(); i++) {
                int v = graph.get(item).get(i).first;
                int wt = graph.get(item).get(i).second;

                if (distances[item] + wt < distances[v]) {
                    distances[v] = distances[item] + wt;
                }
            }
        }
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == 1e9) {
                distances[i] = -1;
            }
        }

        return distances;
    }

    public void topoSort(int node, boolean[] visited, ArrayList<ArrayList<Pair<Integer, Integer>>> adj,
            Stack<Integer> stack) {
        visited[node] = true;
        for (Pair<Integer, Integer> i : adj.get(node)) {
            if (!visited[i.first]) {
                topoSort(i.first, visited, adj, stack);
            }
        }
        stack.add(node);
    }
}
