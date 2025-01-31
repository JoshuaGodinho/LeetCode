class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(!map.containsKey(r-c))
                    map.put(r-c,matrix[r][c]);
                else if(map.get(r-c)!=matrix[r][c])
                    return false;
            }
        }
        return true;
    }
}