class Solution {
    public boolean exist(char[][] board, String word) {
        char[] ch = word.toCharArray();
        boolean ans = false;
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(Character.compare(board[i][j],ch[0]) == 0){
                    ans = ans || dfs(board, i, j, ch, 1, vis);
                }
            }
        }
        return ans;
    }
    public boolean dfs(char[][] board, int i, int j, char[] ch, int start, boolean[][] vis){
        if(start == ch.length)  return true;
        boolean a = false;
        vis[i][j] = true;
        if(i - 1 >= 0 && Character.compare(board[i-1][j],ch[start]) == 0 && !vis[i-1][j]){
            vis[i][j] = true; 
            a = a || dfs(board, i-1, j, ch, start+1, vis);
        }
        if(j - 1 >= 0 && Character.compare(board[i][j-1],ch[start]) == 0 && !vis[i][j-1]){
            vis[i][j] = true; 
            a = a || dfs(board, i, j-1, ch, start+1, vis);
        }
        if(i + 1 < board.length && Character.compare(board[i+1][j],ch[start]) == 0 && !vis[i+1][j]){
            vis[i][j] = true; 
            a = a || dfs(board, i+1, j, ch, start+1, vis);
        }
        if(j + 1 < board[0].length && Character.compare(board[i][j+1],ch[start]) == 0 && !vis[i][j+1]){
            vis[i][j] = true; 
            a = a || dfs(board, i, j+1, ch, start+1, vis);
        }
        vis[i][j] = false;
        return a;
    }
}