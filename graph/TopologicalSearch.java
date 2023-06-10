import java.util.*;

public class TopologicalSearch {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        int[] ans = new int[V];

        int i = 0;
        while (!stack.empty()) {
            ans[i++] = stack.peek();
            stack.pop();
        }

        return ans;
    }

    static void dfs(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int i : adj.get(node)) {
            if (!visited[i])
                dfs(i, visited, stack, adj);
        }
        stack.push(node);
    }
}