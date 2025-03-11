class Solution {
    int[][] directions=new int[][]{{-1,1},{1,1},{1,-1},{-1,-1}};
    int[][] grid;
    int m,n;
    public int lenOfVDiagonal(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        this.grid=grid;
        int result=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    result=Math.max(result,1);
                    result=Math.max(result,dfs(i,j,0,2,false));
                    result=Math.max(result,dfs(i,j,1,2,false));
                    result=Math.max(result,dfs(i,j,2,2,false));
                    result=Math.max(result,dfs(i,j,3,2,false));
                }
            }
        }

        return result;    
    }

    public int dfs(int i,int j,int dir, int target, boolean turned){
        int x=i+directions[dir][0];
        int y=j+directions[dir][1];

        if(x<0 || y<0 || y>=n || x>=m || grid[x][y]!=target)
            return 1;

        int straight= 1+dfs(x,y,dir,target==2?0:2,turned);
        int turn=0;
        if(!turned){
            turn=1+dfs(x,y,(dir+1)%4,target==2?0:2,true);
        }

        return Math.max(straight, turn);
    }
}