class Solution {
    public String shortestCommonSupersequence(String m, String n) {
        int[][] dp = new int[m.length() + 1][n.length() + 1];
        for(int i = 1; i <= m.length() ; i++){
            for(int j = 1; j <= n.length() ; j++){
                if(m.charAt(i-1) == n.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        StringBuilder res = new StringBuilder("");
        int i = m.length() , j = n.length();
        while(i > 0 && j > 0){
            if(m.charAt(i-1) == n.charAt(j-1)){
                res.append(m.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    res.append(m.charAt(i-1));
                    i--;
                }
                else{
                    res.append(n.charAt(j-1));
                    j--;
                }
            }
        }
        while(i > 0){
            res.append(m.charAt(i-1));
            i--;
        }
        while(j > 0){
            res.append(n.charAt(j-1));
            j--;
        }
        return res.reverse().toString();
    }
}