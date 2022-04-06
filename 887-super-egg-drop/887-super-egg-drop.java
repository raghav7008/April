class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int i = 0; i <= k ; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = -1;
            }
        }
        return solve(k, n, dp);
    }
    public int solve(int e, int f, int[][] dp){
        if(f == 0 || f == 1 || e == 1){
            return f;
        }
        if(dp[e][f] != -1)  return dp[e][f];
        int mn = Integer.MAX_VALUE;
        int l=1,r=f;
        while(l<=r)
        {
            int mid=(l+r)/2;
            int left = 0;
            int right = 0;
            if(dp[e-1][mid-1] != -1)  left = dp[e-1][mid-1];
            else{
                left = solve(e-1,mid-1,dp);
                dp[e-1][mid-1] = left;
            }
            if(dp[e][f-mid] != -1)  right = dp[e][f-mid];
            else{
                right = solve(e,f-mid,dp);
                dp[e][f-mid] = right;
            }
            int temp = 1 + Math.max(left,right);
            if(left<right)
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
            mn = Math.min(mn,temp);
        }
        return dp[e][f] = mn;
    }
}