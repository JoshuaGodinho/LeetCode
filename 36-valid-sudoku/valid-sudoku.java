import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Validate rows, columns, and sub-boxes
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> boxSet = new HashSet<>();
            
            for (int j = 0; j < 9; j++) {
                // Check rows
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false; // Duplicate found in row
                    }
                    rowSet.add(board[i][j]);
                }

                // Check columns
                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i])) {
                        return false; // Duplicate found in column
                    }
                    colSet.add(board[j][i]);
                }

                // Check 3x3 sub-boxes
                int rowIndex = 3 * (i / 3) + j / 3; // Starting row of the sub-box
                int colIndex = 3 * (i % 3) + j % 3; // Starting column of the sub-box
                if (board[rowIndex][colIndex] != '.') {
                    if (boxSet.contains(board[rowIndex][colIndex])) {
                        return false; // Duplicate found in sub-box
                    }
                    boxSet.add(board[rowIndex][colIndex]);
                }
            }
        }
        return true; // If no duplicates are found, the board is valid
    }
}
