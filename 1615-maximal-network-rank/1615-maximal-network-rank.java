class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] count = new int[n];
        for(int i = 0; i < roads.length; i++){
            count[roads[i][0]]++;
            count[roads[i][1]]++;
            connected[roads[i][0]][roads[i][1]] = true;
            connected[roads[i][1]][roads[i][0]] = true;
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                res = Math.max(res, count[i] + count[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return res;
    }
}