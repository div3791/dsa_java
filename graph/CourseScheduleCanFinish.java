import java.util.*;

public class CourseScheduleCanFinish {

    // can finish course
    public boolean canFinish(int N, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegrees = new int[N];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j : adj.get(i)) {
                indegrees[j]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();

            ans.add(node);

            for (int j : adj.get(node)) {
                indegrees[j]--;
                if (indegrees[j] == 0) {
                    queue.add(j);
                }
            }
        }

        return ans.size() == N;

    }

    // return order of course schedule
    static int[] findOrder(int N, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.size(); i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegrees = new int[N];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j : adj.get(i)) {
                indegrees[j]++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();

            ans.add(node);

            for (int j : adj.get(node)) {
                indegrees[j]--;
                if (indegrees[j] == 0) {
                    queue.add(j);
                }
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return ans.size() == N ? result : new int[0];
    }

}
