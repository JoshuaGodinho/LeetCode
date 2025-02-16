import java.util.*;

public class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Add all land cells (1s) to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        // Edge Case: If no water or no land, return -1
        if (queue.size() == 0 || queue.size() == n * n) {
            return -1;
        }

        // Step 2: Perform BFS from all land cells
        int maxDistance = -1;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // Right, Down, Left, Up
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDistance++;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                // Explore all four directions
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check if it's a valid water cell
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        grid[newX][newY] = grid[x][y] + 1; // Mark visited & update distance
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = {
            {1, 1, 0, 0},
            {0, 0, 0, 0},
            {1, 1, 0, 1}
        };

        int result = solution.maxDistance(grid);
        System.out.println("Output: " + result);
    }
}
