class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
        dp[row][column] = 1;
        for(; k > 0; k--){
            double[][] dp2 = new double[n][n];
            for(int j = 0; j < n; j++){
                for(int l = 0; l < n; l++){
                    for(int u = 0; u < 8; u++){
                        int currRow = dr[u] + j;
                        int currCol = dc[u] + l;
                        if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < n){
                            dp2[currRow][currCol] += dp[j][l]/8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for(double[] x : dp){
            for(double y : x)   ans += y;
        }
        return ans;
    }
}