class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n=grid.length;
        if(n==0)
            return 0;

        int m=grid[0].length;
        List<int[]> values=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                values.add(new int[]{grid[i][j],i});
            }
        }

        values.sort((a,b)->Integer.compare(b[0],a[0]));

        int[] rowCount=new int[n];
        int picked=0;
        long totalSum=0;

        for(int[] pair:values){
            int val=pair[0];
            int row=pair[1];

            if(rowCount[row]<limits[row] && picked<k){
                totalSum+=val;
                picked++;
                rowCount[row]++;
            }

            if(picked==k)
                break;
        }

        return totalSum;
    }
}