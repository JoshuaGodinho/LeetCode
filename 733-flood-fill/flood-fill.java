class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;

        fill(image,sr,sc,image[sr][sc], color);

        return image;
    }

    private void fill(int[][]  image,int sr, int sc, int oldColor, int newColor){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length )
            return;
        
        if(oldColor!=image[sr][sc])
            return;

        image[sr][sc]=newColor;

        fill(image, sr-1,sc,oldColor,newColor);
        fill(image, sr+1,sc,oldColor,newColor);
        fill(image, sr,sc-1,oldColor,newColor);
        fill(image, sr,sc+1,oldColor,newColor);
    }
}