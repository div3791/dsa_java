import java.util.*;

public class CourseScheduleCanFinish {
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

}
