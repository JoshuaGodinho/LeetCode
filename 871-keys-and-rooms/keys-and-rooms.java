
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];  // Track visited rooms
        dfs(rooms, 0, visited);  // Start DFS from room 0
        
        // Check if all rooms are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        visited[room] = true; // Mark current room as visited
        for (int key : rooms.get(room)) { // Explore all keys in the current room
            if (!visited[key]) {
                dfs(rooms, key, visited);
            }
        }
    }
}