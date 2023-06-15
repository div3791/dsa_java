import java.util.*;

public class DijkstrasAlgo {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distances = new int[V];
        for (int i = 0; i < V; i++)
            distances[i] = (int) 1e9;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        distances[S] = 0;

        pq.add(new Pair(0, S));

        while (pq.size() != 0) {
            Pair p = pq.peek();
            int dist = p.distance;
            int node = p.node;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int wt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dist + wt < distances[adjNode]) {
                    distances[adjNode] = dist + wt;
                    pq.add(new Pair(distances[adjNode], adjNode));
                }
            }
        }

        return distances;
    }

    static class Pair {
        int distance;
        int node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
}
