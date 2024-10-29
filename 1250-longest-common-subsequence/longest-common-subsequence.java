class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Initialize the DP table with dimensions (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];
        
        // Iterate from the end of both strings towards the beginning
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        // The answer is in dp[0][0]
        return dp[0][0];
    }
}
