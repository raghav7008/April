class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[] temp = q.remove();
            int moves = temp[0];
            int pos = temp[1];
            int speed = temp[2];
            if(pos == target)   return moves;
            if(vis.contains(String.valueOf(pos) + "+" + String.valueOf(speed)))   continue;
            else{
                vis.add(String.valueOf(pos) + "+" + String.valueOf(speed));
                q.offer(new int[]{moves+1, pos + speed, speed * 2});
                
                if((pos + speed > target && speed > 0) || (pos + speed < target && speed < 0)){   
                    speed = speed > 0 ? -1 : 1;
                    q.offer(new int[]{moves+1, pos, speed});                             
                }
            }
        }
        return -1;
    }
}