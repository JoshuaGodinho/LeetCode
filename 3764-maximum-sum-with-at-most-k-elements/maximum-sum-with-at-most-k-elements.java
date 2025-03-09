class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n=grid.length;
        if(n==0)
            return 0;

        int m=grid[0].length;
        PriorityQueue<int[]> values = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                values.add(new int[]{grid[i][j],i});
            }
        }

        int[] rowCount=new int[n];
        long totalSum=0;

        while(k>0 && !values.isEmpty()){
            int[] value=values.poll();
            int val=value[0];
            int row=value[1];

            if(rowCount[row]<limits[row]){
                totalSum+=val;
                rowCount[row]++;
                k--;
            }
        }
        
        return totalSum;
    }
}