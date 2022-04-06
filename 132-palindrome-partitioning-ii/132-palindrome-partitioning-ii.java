class Solution {
    public int minCut(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for(int i = 0; i <= s.length() ; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s, 0, s.length() - 1, dp);
    }
    public int solve(String s, int i, int j, int[][] dp){
        if(i >= j)  return 0;
        if(isPalindrome(s,i,j)) return 0;
        if(dp[i][j] != -1)  return dp[i][j];
        int mn = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            if(isPalindrome(s,i,k)){
                int temp = solve(s,k+1,j,dp) + 1;
                mn = Math.min(mn,temp);
            }
        }
        return dp[i][j] = mn;
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))    return false;
            start++;
            end--;
        }
        return true;
    }
}