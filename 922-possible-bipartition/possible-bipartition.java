import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize adjacency list for graph representation
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph using given dislikes
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }

        int[] color = new int[n + 1]; // -1: uncolored, 0 & 1: two colors
        Arrays.fill(color, -1);

        // Check each component (some people may not have dislikes)
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                // Start BFS from this node
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int neighbor : graph.get(node)) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            queue.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false; // Conflict detected
                        }
                    }
                }
            }
        }
        return true; // If no conflicts, possible bipartition
    }
}
