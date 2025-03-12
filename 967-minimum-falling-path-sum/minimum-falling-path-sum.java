class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int left=(j>0) ? matrix[i-1][j-1] : Integer.MAX_VALUE;
                int up=matrix[i-1][j];
                int right=(j<n-1) ? matrix[i-1][j+1]: Integer.MAX_VALUE;

                matrix[i][j]+= Math.min(up, Math.min(left,right));
            }
        }

        int min=Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, matrix[n - 1][j]);
        }

        return min;
    }
}