import java.util.*;

public class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        boolean[] safeNodes = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, safeNodes, pathVisited);
            }
            if (safeNodes[i])
                result.add(i);
        }
        return result;
    }

    public boolean dfs(
            int node,
            int[][] graph,
            boolean[] visited,
            boolean[] safeNodes,
            boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;
        safeNodes[node] = false;

        for (int i : graph[node]) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, safeNodes, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[i]) {
                return true;
            }
        }

        pathVisited[node] = false;
        safeNodes[node] = true;

        return false;
    }
}
