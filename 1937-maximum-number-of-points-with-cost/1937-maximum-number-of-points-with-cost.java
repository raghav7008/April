class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length, m = points[0].length;
        long[] pre = new long[m];
        for(int i = 0; i < points[0].length; i++)  pre[i] = points[0][i];
        for(int i = 0; i < n - 1; i++){
            long[] left = new long[m];
            long[] right = new long[m];
            long[] curr = new long[m];
            left[0] = pre[0];
            right[m-1] = pre[m-1];
            for(int j = 1; j < m; j++)  left[j] = Math.max(left[j-1]-1, pre[j]);
            for(int j = m - 2; j >= 0; j--)  right[j] = Math.max(right[j+1]-1, pre[j]);
            for(int j = 0; j < m; j++)  curr[j] = points[i+1][j] + Math.max(left[j],right[j]);
            pre = curr;
        }
        long ans = 0;
        for(int i = 0; i < m; i++)  ans = Math.max(ans, pre[i]);
        return ans;
    }
}