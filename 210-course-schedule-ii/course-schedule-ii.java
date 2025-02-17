import java.util.*;

class Solution {
    private List<Integer>[] adjList;
    private Stack<Integer> stack;
    private boolean[] visited;
    private boolean[] onStack;
    private boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adjList = new ArrayList[numCourses];
        stack = new Stack<>();
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] pre : prerequisites) {
            adjList[pre[1]].add(pre[0]); // Directed edge from pre[1] to pre[0]
        }

        // Run DFS on all unvisited nodes
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // If cycle is detected, return an empty array
        if (hasCycle) {
            return new int[0];
        }

        // Convert stack to result array
        int[] order = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            order[index++] = stack.pop();
        }
        return order;
    }

    private void dfs(int node) {
        if (hasCycle) return; // Stop if a cycle is already found

        visited[node] = true;
        onStack[node] = true;

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            } else if (onStack[neighbor]) { // If the neighbor is on the stack, cycle exists
                hasCycle = true;
                return;
            }
        }

        onStack[node] = false; // Remove from recursion stack
        stack.push(node); // Add to topological order
    }
}
