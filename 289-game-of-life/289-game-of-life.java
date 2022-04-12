class Solution {
    public void gameOfLife(int[][] board) {
        int[][] ans = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                sahiKardoIsko(board, i, j, ans);
            }
        }
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[0].length ; j++){
                board[i][j] = ans[i][j];
            }
        }
    }
    public void sahiKardoIsko(int[][] board, int i, int j, int[][] ans){
        int n1 = j > 0 ? board[i][j-1] : 0;
        int n2 = j > 0 && i > 0 ? board[i-1][j-1] : 0;
        int n3 = i > 0 ? board[i-1][j] : 0;
        int n4 = j < board[0].length -1 && i > 0 ? board[i-1][j+1] : 0;
        int n5 = j < board[0].length - 1 ? board[i][j+1] : 0;
        int n6 = j < board[0].length - 1 && i < board.length - 1 ? board[i+1][j+1] : 0;
        int n7 = i < board.length - 1 ? board[i+1][j] : 0;
        int n8 = i < board.length - 1 && j > 0 ? board[i+1][j-1] : 0;
        int count = n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8;
        if(count < 2)   ans[i][j] = 0;
        else if( count == 3)    ans[i][j] = 1;
        else if( count == 2)    ans[i][j] = board[i][j];
        else    ans[i][j] = 0;
    }
}