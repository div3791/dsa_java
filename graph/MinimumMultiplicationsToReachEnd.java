import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {

        Queue<Pair> queue = new LinkedList<>();

        int[] distances = new int[100000];

        Arrays.fill(distances, (int) 1e9);

        int mode = 100000;

        queue.add(new Pair(0, start));

        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int steps = queue.peek().steps;
            queue.remove();

            for (int i : arr) {
                int num = (i * node) % mode;
                if (steps + 1 < distances[num]) {
                    distances[num] = steps + 1;

                    if (num == end) {
                        return steps + 1;
                    }

                    queue.add(new Pair(steps + 1, num));
                }
            }
        }

        return -1;
    }

    class Pair {
        int steps;
        int node;

        Pair(int steps, int node) {
            this.steps = steps;
            this.node = node;
        }
    }
}
