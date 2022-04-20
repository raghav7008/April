class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0)    return 0;
        int countFresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) countFresh++;
                else if(grid[i][j] == 2)    q.add(new int[]{i , j});
            }
        }
        if(countFresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            ++count;
            int size = q.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = q.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x , y});
                    countFresh--;
                }
            }
        }
        if(countFresh == 0) return count-1;
        return -1;
    }
}