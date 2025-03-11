class Solution {

    // Four diagonal directions in clockwise order:
    // down-right, down-left, up-left, up-right
    private final int[][] directions = {
        { 1,  1},  // 0
        { 1, -1},  // 1
        {-1, -1},  // 2
        {-1,  1}   // 3
    };
    
    // dp[r][c][dir][canTurn][targetIndex]:
    //   r, c: current cell
    //   dir: which diagonal direction (0..3)
    //   canTurn: 1 if we can still turn once, 0 if we've already turned
    //   targetIndex: 0 => we expect 0 in next cell, 1 => we expect 2
    private int[][][][][] dp;
    private int[][] grid;
    private int R, C;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        if (R == 0) return 0;
        C = grid[0].length;
        if (C == 0) return 0;

        // Allocate a memo array, initialized to -1 (meaning "uncomputed")
        // Dimensions: [R][C][4 directions][2 possible canTurn][2 possible targetIndex]
        dp = new int[R][C][4][2][2];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int d = 0; d < 4; d++) {
                    for (int t = 0; t < 2; t++) {
                        dp[r][c][d][t][0] = -1;
                        dp[r][c][d][t][1] = -1;
                    }
                }
            }
        }

        int res = 0;
        
        // We must start on a cell containing '1'.
        // From that cell, we look for '2' next (targetIndex = 1),
        // and we allow one clockwise turn (canTurn = 1).
        // We add +1 for the starting '1' cell itself.
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        // (r,c) is the '1'; we call dfs to find how many we can get after this
                        int chainLen = 1 + dfs(r, c, dir, 1, 1);
                        res = Math.max(res, chainLen);
                    }
                }
            }
        }
        
        return res;
    }
    
    // nextTargetIndex(0) => 1 (looking for 2), nextTargetIndex(1) => 0 (looking for 0)
    private int nextTargetIndex(int cur) {
        return 1 - cur;
    }
    
    // DFS: Move one step in 'dir' from (r,c), check if that next cell has the 'target' (0 or 2).
    //      If yes, continue. Also, if canTurn == 1, we can attempt a single clockwise turn.
    private int dfs(int r, int c, int dir, int canTurn, int targetIndex) {
        // Move along dir
        r += directions[dir][0];
        c += directions[dir][1];
        
        // neededVal = 0 or 2
        int neededVal = (targetIndex == 0 ? 0 : 2);
        
        // If out of bounds or doesn't match => chain ends
        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] != neededVal) {
            return 0;
        }
        
        // If we've computed this state before, return it
        if (dp[r][c][dir][canTurn][targetIndex] != -1) {
            return dp[r][c][dir][canTurn][targetIndex];
        }
        
        int nextIdx = nextTargetIndex(targetIndex);
        
        // Continue straight
        int best = dfs(r, c, dir, canTurn, nextIdx);
        
        // Try a single clockwise turn if still allowed
        if (canTurn == 1) {
            int turnDir = (dir + 1) % 4;
            best = Math.max(best, dfs(r, c, turnDir, 0, nextIdx));
        }
        
        // Include this cell in the chain length
        dp[r][c][dir][canTurn][targetIndex] = best + 1;
        return best + 1;
    }
}
