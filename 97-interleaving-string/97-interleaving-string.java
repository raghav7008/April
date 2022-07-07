class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp = new int[s1.length()][s2.length()];
        if(s1.length() + s2.length() != s3.length())    return false;
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                dp[i][j] = -1;
            }
        }
        return getAns(s1, 0, s2, 0, s3, 0, dp);
    }
    public boolean getAns(String s1, int i, String s2, int j, String s3, int k, int[][] dp){
        if(i == s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j == s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }
        if(dp[i][j] >= 0)   return dp[i][j] == 1 ? true : false;
        boolean res = false;
        if((s3.charAt(k) == s1.charAt(i) && getAns(s1, i+1, s2, j, s3, k+1, dp)) || (s3.charAt(k) == s2.charAt(j) && getAns(s1, i, s2, j+1, s3, k+1, dp)))  res = true;
        dp[i][j] = res ? 1 : 0;
        return res;
    }
}