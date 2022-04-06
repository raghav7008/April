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
            int left = solve(e-1,mid-1,dp);
            int right = solve(e,f-mid,dp);
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