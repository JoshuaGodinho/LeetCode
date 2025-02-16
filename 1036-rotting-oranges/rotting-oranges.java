import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0, minutes = 0;

        // Step 1: Add all rotten oranges to the queue & count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // Rotten orange position
                } else if (grid[i][j] == 1) {
                    freshOranges++; // Count fresh oranges
                }
            }
        }

        // If no fresh oranges exist, return 0
        if (freshOranges == 0) return 0;

        // Step 2: Start BFS
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Up, Down, Right, Left
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenInThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                // Spread to adjacent fresh oranges
                for (int[] dir : directions) {
                    int newX = x + dir[0], newY = y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Rot the orange
                        queue.offer(new int[]{newX, newY});
                        freshOranges--; // Reduce fresh orange count
                        rottenInThisMinute = true;
                    }
                }
            }
            if (rottenInThisMinute) minutes++; // Increment time only if rot spread
        }

        return (freshOranges == 0) ? minutes : -1; // If any fresh orange remains, return -1
    }
}
