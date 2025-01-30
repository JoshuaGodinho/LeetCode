class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat==null || mat.length==0)
            return new int[0];

        int rowLength=mat.length;
        int colLength=mat[0].length;

        int[] result=new int[rowLength*colLength];
        int k=0;
        ArrayList<Integer> intermediate=new ArrayList<>();

        for(int i=0;i<rowLength+colLength-1;i++){
            intermediate.clear();

            int row= i<colLength?0:i-colLength+1;
            int col=i<colLength?i:colLength-1;

            while(row<rowLength && col>-1){
                intermediate.add(mat[row][col]);
                row++;
                col--;
            }

            if(i%2==0){
                Collections.reverse(intermediate);
            }

            for(int j=0;j<intermediate.size();j++){
                result[k++]=intermediate.get(j);
            }
        }

        return result;
    }
}