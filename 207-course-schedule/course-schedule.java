import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list and in-degree array
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 2: Build the graph and update in-degrees
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adjList.get(prereq).add(course);
            inDegree[course]++;
        }

        // Step 3: Use a queue for BFS (add courses with in-degree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Process the courses
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++;

            // Reduce the in-degree of neighboring courses
            for (int neighbor : adjList.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 5: If all courses are processed, return true, otherwise false
        return processedCourses == numCourses;
    }
}
