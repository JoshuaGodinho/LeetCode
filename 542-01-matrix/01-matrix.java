import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Initialize the queue with all 0s and mark 1s as -1 (unvisited)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j}); // Add all 0s to queue
                } else {
                    mat[i][j] = -1; // Mark unvisited 1s
                }
            }
        }

        // Step 2: BFS to update distances
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Skip out-of-bounds and already visited cells
                if (newX < 0 || newY < 0 || newX >= rows || newY >= cols || mat[newX][newY] != -1) {
                    continue;
                }

                // Update distance for the new cell and add it to the queue
                mat[newX][newY] = mat[x][y] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }

        return mat;
    }
}
