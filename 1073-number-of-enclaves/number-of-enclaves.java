class Solution {
    private int rows, cols;

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        rows = grid.length;
        cols = grid[0].length;

        // Step 1: Remove all 1s connected to the border using DFS
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0); // First column
            if (grid[i][cols - 1] == 1) dfs(grid, i, cols - 1); // Last column
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) dfs(grid, 0, j); // First row
            if (grid[rows - 1][j] == 1) dfs(grid, rows - 1, j); // Last row
        }

        // Step 2: Count remaining 1s as enclaves
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        // Base case: Out of bounds or already visited
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 1) return;

        // Mark as visited
        grid[i][j] = -1;

        // Explore all 4 directions (up, down, left, right)
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}