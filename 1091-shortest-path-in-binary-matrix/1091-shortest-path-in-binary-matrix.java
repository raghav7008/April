class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0] == 1) return -1;
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] temp = q.remove();
                if(temp[0] == r-1 && temp[1] == c-1)    return temp[2];
                for(int j = 0; j < dir.length; j++){
                    int t1 = temp[0] + dir[j][0];
                    int t2 = temp[1] + dir[j][1];
                    if(t1 < r && t2 < c && t1 >= 0 && t2 >= 0 && grid[t1][t2] == 0){
                        q.offer(new int[]{t1,t2,temp[2]+1});
                        grid[t1][t2] = 1;
                    }
                }
            }
        }
        return -1;
    }
}