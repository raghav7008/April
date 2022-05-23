class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m + 1; i++){
            Arrays.fill(dp[i], 0);
        }
        int[] temp = new int[]{0,0};
        for(String s : strs){
            temp = count(s);
            for(int i = m; i >= temp[0]; i--){
                for(int j = n; j >= temp[1]; j--){
                    if(i >= temp[0] && j >= temp[1]){
                        dp[i][j] = Math.max(dp[i-temp[0]][j-temp[1]] + 1, dp[i][j]);
                    }
                    else    dp[i][j] = dp[i][j];
                }
            }
        }
        return dp[m][n];
    }
    public int[] count(String s){
        int[] temp = new int[]{0,0};
        for(int i = 0; i < s.length(); i++){
            temp[s.charAt(i)-'0']++;
        }
        return temp;
    }
}