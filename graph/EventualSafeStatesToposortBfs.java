import java.util.*;

public class EventualSafeStatesToposortBfs {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();
        int[] indegree = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                reversedGraph.get(j).add(i);
                indegree[j]++;
            }
        }

        for (int i = 0; i < reversedGraph.size(); i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int item = queue.peek();
            queue.remove();
            result.add(item);

            for (int i : reversedGraph.get(item)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        Collections.sort(result);
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
