import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // If start or end is blocked, return -1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        // Directions for 8-way movement
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };

        // BFS queue (row, col, steps)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        
        // Mark start as visited
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], steps = cell[2];

            // If we reached the bottom-right cell
            if (row == n - 1 && col == n - 1) return steps;

            // Explore all 8 possible directions
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];

                // Check bounds and if the cell is unvisited (0)
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol, steps + 1});
                    grid[newRow][newCol] = 1; // Mark as visited
                }
            }
        }
        
        return -1; // No valid path found
    }
}
