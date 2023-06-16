import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] items : roads) {
            int u = items[0];
            int v = items[1];
            int dist = items[2];

            adj.get(u).add(new Pair(v, dist));
            adj.get(v).add(new Pair(u, dist));
        }
        int mod = (int) (1e9 * 7);
        int[] distances = new int[n];
        int[] ways = new int[n];
        Arrays.fill(distances, (int) 1e9);
        Arrays.fill(ways, 0);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        distances[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.peek();
            int node = p.node;
            int dist = p.dist;
            pq.remove();

            for (Pair item : adj.get(node)) {
                int newNode = item.node;
                int newDist = item.dist;

                if (newDist + dist < distances[newNode]) {
                    distances[newNode] = newDist + dist;
                    pq.add(new Pair(newNode, newDist + dist));
                    ways[newNode] = ways[node];
                } else if (newDist + dist == distances[newNode]) {
                    ways[newNode] = (ways[newNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }

    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
