
class ReplaceOWithX {

    char[][] input = {
            { 'X', 'O', 'X', 'O', 'X', 'O' },
            { 'O', 'X', 'O', 'X', 'O', 'X' },
            { 'X', 'O', 'X', 'O', 'X', 'O' },
            { 'O', 'X', 'O', 'X', 'O', 'X' }
    };

    char[][] output = {
            { 'X', 'O', 'X', 'O', 'X', 'O' },
            { 'O', 'X', 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X', 'X', 'O' },
            { 'O', 'X', 'O', 'X', 'O', 'X' }
    };

    public char[][] solve(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            if (grid[i][0] != 'X') {
                DFS(i, 0, grid);
            }

            if (grid[i][m - 1] != 'X') {
                DFS(i, m - 1, grid);
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[0][i] != 'X') {
                DFS(0, i, grid);
            }

            if (grid[n - 1][i] != 'X') {
                DFS(n - 1, i, grid);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                    continue;
                }
                if (grid[i][j] == 'D') {
                    grid[i][j] = 'O';
                    continue;
                }
            }
        }

        return grid;
    }

    public void DFS(int i, int j, char[][] grid) {
        if (!(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 'O')) {
            return;
        }
        grid[i][j] = 'D';
        DFS(i + 1, j, grid);
        DFS(i, j + 1, grid);
        DFS(i - 1, j, grid);
        DFS(i, j - 1, grid);
    }

}
