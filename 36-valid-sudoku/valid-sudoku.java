class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set=new HashSet<>();
        //row check
        for(int i=0;i<9;i++){
            set.clear();
            for(int j=0;j<9;j++){
                char current=board[i][j];
                if(current=='.')
                    continue;
                if(set.contains(current))
                    return false;
                else
                    set.add(current);
            }
        }
        System.out.println("Row check complete");

        //col check
        for(int i=0;i<9;i++){
            set.clear();
            for(int j=0;j<9;j++){
                char current=board[j][i];
                if(current=='.')
                    continue;
                if(set.contains(current))
                    return false;
                else
                    set.add(current);
            }
        }
        System.out.println("Col check complete");

        set.clear();
        //3*3 square check
        int rowMin=0;
        int rowMax=2;
        int colMin=0;
        int colMax=2;
        for(int a=0;a<3;a++){
            for(int b=0;b<3;b++){
                for(int i=rowMin;i<=rowMax;i++){
                    for(int j=colMin;j<=colMax;j++){
                        char c=board[i][j];
                        if(set.contains(c)) 
                            return false;
                        if(c!='.')    
                            set.add(c);
                    }                    
                }
                set.clear();
                colMin+=3;
                colMax+=3;
            }
            rowMin+=3;
            rowMax+=3;
            colMin=0;
            colMax=2;
        }
        return true;
    }
}