class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        if(n <= 0)  return res;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        helper(board, 0, res);
        return res;
    }
    public void helper(char[][] board, int row, List<List<String>> res){
        if(row == board.length){
            res.add(build(board));
            return;
        }
        for(int i = 0; i < board.length; i++){
            board[row][i] = 'Q';
            if(isValid(board, row, i)){
                helper(board, row + 1, res);
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
    public List<String> build(char[][] board){
        List<String> temp = new ArrayList();
        for(int i = 0; i < board.length; i++){
            String t = new String(board[i]);
            temp.add(t);
        }
        return temp;
    }
}