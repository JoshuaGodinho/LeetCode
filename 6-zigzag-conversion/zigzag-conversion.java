class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)  return s;

        int n=s.length();
        int sections=(int) Math.ceil(n/(2*numRows-2.0));

        int numCols=sections*(numRows-1);

        char[][] matrix=new char[numRows][numCols];
        for(char[] row: matrix)
        {
            Arrays.fill(row,' ');
        }

        int currRow=0; int currCol=0;
        int currStringIndex=0;
        while(currStringIndex<n)
        {
            while(currRow<numRows && currStringIndex<n)
            {
                matrix[currRow][currCol]=s.charAt(currStringIndex);
                currRow++;
                currStringIndex++;
            }
            currCol++;
            currRow-=2;
            while(currRow> 0 && currCol < numCols && currStringIndex<n)
            {
                matrix[currRow][currCol]=s.charAt(currStringIndex);
                currRow--;
                currCol++;
                currStringIndex++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char[] row:matrix)
        {
            for(char character:row)
            {
                if(character!=' ')
                    sb.append(character);
            }
        }

        return sb.toString();
    }
}