class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;

        int[] balloons=new int[n+2];
        balloons[0]=balloons[n+1]=1;

        for(int i=0;i<n;i++)
            balloons[i+1]=nums[i];

        int[][] dp=new int[n+2][n+2];

        for(int length=2;length<n+2;length++){
            for(int left=0; left+length <n+2;  left++){
                int right=left+length;
                for(int k=left+1;k<right;k++){

                    dp[left][right]=Math.max(dp[left][right], dp[left][k]+dp[k][right]+balloons[left]*balloons[k]*balloons[right]);

                }
            }
        }

        return dp[0][n+1];
    }
}