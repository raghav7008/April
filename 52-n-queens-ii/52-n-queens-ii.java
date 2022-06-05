class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if(n <= 0)  return 0;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        helper(board, 0);
        return count;
    }
    public void helper(char[][] board, int row){
        if(row == board.length){
            count++;
            return;
        }
        for(int i = 0; i < board.length; i++){
            board[row][i] = 'Q';
            if(isValid(board, row, i)){
                helper(board, row + 1);
            }
            board[row][i] = '.';
        }
    }
    public boolean isValid(char[][] board, int row, int col){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < board.length; j++){
                if(i == row && j == col)    continue;
                if((j == col || Math.abs(row - i) == Math.abs(col - j)) && board[i][j] == 'Q')  return false;
            }
        }
        return true;
    }
}