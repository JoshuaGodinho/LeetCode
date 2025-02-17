import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // -1: uncolored, 0 & 1: two colors
        Arrays.fill(color, -1); // Initially mark all nodes as uncolored

        // Check each component (graph may be disconnected)
        for (int i = 0; i < n; i++) {
            if (color[i] != -1) continue; // Skip already colored nodes

            // Start BFS from this node
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 0; // Color the first node as 0

            while (!queue.isEmpty()) {
                int node = queue.poll();

                // Check all its adjacent nodes
                for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) { // If not colored, assign opposite color
                        color[neighbor] = 1 - color[node];
                        queue.add(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        return false; // Conflict detected
                    }
                }
            }
        }
        return true; // If no conflicts, graph is bipartite
    }
}
