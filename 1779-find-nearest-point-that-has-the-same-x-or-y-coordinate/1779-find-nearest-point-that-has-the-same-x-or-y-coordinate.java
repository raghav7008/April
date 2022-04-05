class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDist = Integer.MAX_VALUE;
        int loc = -1;
        for(int i = 0; i < points.length ; i++){
            if(points[i][0] == x){
                int tempDist = Math.abs(x-points[i][0]) + Math.abs(y-points[i][1]);
                if(tempDist < minDist){
                    minDist = tempDist;
                    loc = i;
                }
            }
            if(points[i][1] == y){
                int tempDist = Math.abs(x-points[i][0]) + Math.abs(y-points[i][1]);
                if(tempDist < minDist){
                    minDist = tempDist;
                    loc = i;
                }
            }
        }
        return loc;
    }
}