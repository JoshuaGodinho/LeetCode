class orange{
    int row,col,mins;
    public orange(int row, int col, int mins){
        this.row=row;
        this.col=col;
        this .mins=mins;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int fresh=0;

        Queue<orange> queue=new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2){
                    queue.add(new orange(i,j,0));
                    grid[i][j]=0;
                }
            }
        }

        if(queue.isEmpty() && fresh==0)
            return 0;

        int maxMin=0;
        int rowDiff[]={-1,0,0,1};
        int colDiff[]={0,-1,1,0};

        while(!queue.isEmpty()){
            orange current=queue.poll();
            maxMin=Math.max(maxMin, current.mins);

            for(int i=0;i<4;i++){
                int adjr=current.row+rowDiff[i];
                int adjc=current.col+colDiff[i];

                if(adjr>=0 && adjr<row && adjc>=0 && adjc<col && grid[adjr][adjc]==1){
                    queue.add(new orange(adjr,adjc,current.mins+1));
                    fresh--;
                    grid[adjr][adjc]=0;
                }
            }
        }

        if(fresh>0)
            return -1;
        
        return maxMin;
    }
    
}