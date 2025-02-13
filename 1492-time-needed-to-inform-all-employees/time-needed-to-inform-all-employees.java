import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Step 1: Build the hierarchical tree as an adjacency list
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {  // Skip CEO as they have no manager
                tree.putIfAbsent(manager[i], new ArrayList<>());
                tree.get(manager[i]).add(i);
            }
        }

        // Step 2: Use DFS to calculate the maximum time required
        return dfs(tree, informTime, headID);
    }

    private int dfs(Map<Integer, List<Integer>> tree, int[] informTime, int manager) {
        if (!tree.containsKey(manager)) {
            return 0;  // Base case: If the manager has no direct reports, return 0
        }

        int maxTime = 0;
        for (int employee : tree.get(manager)) {
            maxTime = Math.max(maxTime, dfs(tree, informTime, employee));
        }

        return maxTime + informTime[manager];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 6;
        int headID = 2;
        int[] manager = {2, 2, -1, 2, 2, 3};
        int[] informTime = {0, 0, 1, 2, 1, 3};

        System.out.println("Time to inform all employees: " + sol.numOfMinutes(n, headID, manager, informTime));
    }
}
