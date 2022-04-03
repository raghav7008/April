class Solution {
    public int minDistance(String m, String n) {
        int[][] dp = new int[m.length()+1][n.length()+1];
        for(int i = 1; i <= m.length(); i++){
            for(int j = 1; j <= n.length(); j++){
                if(m.charAt(i-1) == n.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return (m.length() - dp[m.length()][n.length()]) + (n.length() - dp[m.length()][n.length()]);
    }
}