class Solution {
    int[] dirs = {0, 1, 0, -1, 0};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if(k >= m + n - 2)  return m + n - 2;
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] vis = new boolean[m][n][k+1];
        q.offer(new int[]{0,0,k,0});
        vis[0][0][k] = true;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0], c = temp[1], curr = temp[2], dis = temp[3];
            if(r == m - 1 && c == n - 1)    return dis;
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i], nc = c + dirs[i + 1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n)  continue;
                int nk = curr - grid[nr][nc];
                if(nk >= 0 && !vis[nr][nc][nk]){
                    q.offer(new int[]{nr, nc, nk, dis + 1});
                    vis[nr][nc][nk] = true;
                }
            }
        }
        return -1;
    }
}