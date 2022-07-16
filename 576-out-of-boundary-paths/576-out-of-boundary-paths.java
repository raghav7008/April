class Solution {
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for (int[][] l : dp) for(int[] sl : l) Arrays.fill(sl, -1);
        return (int) dfs(m, n, maxMove, startRow, startColumn, dp) % mod;
    }
    public int dfs(int m, int n, int max, int row, int col, int[][][] dp){
        if(row < 0 || col < 0 || row == m || col == n){
            return 1;
        }
        if(max == 0){
            return 0 ;
        }
        if(dp[row][col][max] != -1)  return dp[row][col][max];
        dp[row][col][max] = (
        (dfs(m, n, max - 1, row - 1, col, dp) + dfs(m, n, max - 1, row + 1, col, dp)) % mod +
        (dfs(m, n, max - 1, row, col - 1, dp) + dfs(m, n, max - 1, row, col + 1, dp)) % mod
    ) % mod;
        return dp[row][col][max];
    }
}