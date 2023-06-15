import java.util.*;

public class ShortestPathInUndirected {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        int[] distance = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            distance[i] = (int) 1e9;
        }
        distance[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int item = queue.peek();
            queue.remove();

            for (int i : adj.get(item)) {
                if (distance[item] + 1 < distance[i]) {
                    distance[i] = distance[item] + 1;
                    queue.add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == 1e9) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    public List<Integer> printShortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);

        int[] parent = new int[n + 1];
        int[] distances = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            distances[i] = (int) 1e9;
            parent[i] = i;
        }
        distances[1] = 0;

        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair it = pq.peek();
            int node = it.node;
            int dic = it.dist;
            pq.remove();

            for (Pair iter : adj.get(node)) {
                int adjnode = iter.node;
                int edgeweigth = iter.dist;
                if (dic + edgeweigth < distances[adjnode]) {
                    distances[adjnode] = dic + edgeweigth;
                    pq.add(new Pair(dic + edgeweigth, adjnode));
                    parent[adjnode] = node;
                }
            }
        }

        ArrayList<Integer> src = new ArrayList<>();
        if (distances[n] == (int) 1e9) {
            src.add(-1);
            return src;
        }

        int node = n;

        getPath(node, distances, parent, src);
        src.add(n);
        return src;

    }

    List<Integer> getPath(int node, int[] distances, int[] parents, List<Integer> path) {

        if (parents[node] == node) {
            return path;
        }

        node = parents[node];
        getPath(node, distances, parents, path);
        path.add(node);
        return path;
    }

    class Pair {
        int dist;
        int node;

        Pair(int distance, int node) {
            this.dist = distance;
            this.node = node;
        }
    }
}
