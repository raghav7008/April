// class Solution {
//     int count = 0;
//     public int totalNQueens(int n) {
//         if(n <= 0)  return 0;
//         char[][] board = new char[n][n];
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 board[i][j] = '.';
//             }
//         }
//         helper(board, 0);
//         return count;
//     }
//     public void helper(char[][] board, int row){
//         if(row == board.length){
//             count++;
//             return;
//         }
//         for(int i = 0; i < board.length; i++){
//             board[row][i] = 'Q';
//             if(isValid(board, row, i)){
//                 helper(board, row + 1);
//             }
//             board[row][i] = '.';
//         }
//     }
//     public boolean isValid(char[][] board, int row, int col){
//         for(int i = 0; i < row; i++){
//             for(int j = 0; j < board.length; j++){
//                 if(i == row && j == col)    continue;
//                 if((j == col || Math.abs(row - i) == Math.abs(col - j)) && board[i][j] == 'Q')  return false;
//             }
//         }
//         return true;
//     }
// }
public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }
    
    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;
            
            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}