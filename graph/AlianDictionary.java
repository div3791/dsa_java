import java.util.*;

public class AlianDictionary {
    public String findOrder(String[] dict, int N, int K) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        int[] topo = topoSort(K, adj);

        String ans = "";
        for (int i : topo) {
            ans = ans + (char) (i + (int) ('a'));
        }

        return ans;
    }

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
