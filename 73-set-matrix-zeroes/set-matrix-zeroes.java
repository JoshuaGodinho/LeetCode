class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[] zeroRow=new boolean[m];
        boolean[] zeroCol=new boolean[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    zeroRow[i]=true;
                    zeroCol[j]=true;
                }
            }
        }

        for(int i=0;i<m;i++){
            if(zeroRow[i]){
               for(int j=0;j<n;j++){
                    matrix[i][j]=0;
               } 
            }
        }

        for(int i=0;i<n;i++){
            if(zeroCol[i]){
               for(int j=0;j<m;j++){
                    matrix[j][i]=0;
               } 
            }
        }
    }
}