public class NumberOfEcnclaves {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (grid[i][0] != 0) {
                DFS(i, 0, grid);
            }

            if (grid[i][m - 1] != 0) {
                DFS(i, m - 1, grid);
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[0][i] != 0) {
                DFS(0, i, grid);
            }

            if (grid[n - 1][i] != 0) {
                DFS(n - 1, i, grid);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    counter++;
                }

            }
        }

        return counter;

    }

    public void DFS(int i, int j, int[][] grid) {
        if (!(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1)) {
            return;
        }
        grid[i][j] = -1;
        DFS(i + 1, j, grid);
        DFS(i, j + 1, grid);
        DFS(i - 1, j, grid);
        DFS(i, j - 1, grid);
    }
}
