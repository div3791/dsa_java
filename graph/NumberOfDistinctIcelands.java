import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIcelands {
    int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, grid, list, i, j);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    void dfs(int i, int j, int[][] grid, ArrayList<String> list, int nrow, int ncol) {
        if (!(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1)) {
            return;
        }

        grid[i][j] = -1;
        list.add(toString(i - nrow, j - ncol));

        dfs(i + 1, j, grid, list, nrow, ncol);
        dfs(i - 1, j, grid, list, nrow, ncol);
        dfs(i, j + 1, grid, list, nrow, ncol);
        dfs(i, j - 1, grid, list, nrow, ncol);
    }

    String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
