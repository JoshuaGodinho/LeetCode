import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // Step 1: Create adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]}); // (neighbor, weight)
        }

        // Step 2: Initialize min-heap (priority queue)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 
        pq.offer(new int[]{0, K}); // (distance, node)

        // Step 3: Distance array
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        // Step 4: Process nodes
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], node = current[1];

            if (!graph.containsKey(node)) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], weight = neighbor[1];

                if (dist[nextNode] > time + weight) { // Relaxation step
                    dist[nextNode] = time + weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        // Step 5: Get the maximum distance
        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // Not reachable
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
