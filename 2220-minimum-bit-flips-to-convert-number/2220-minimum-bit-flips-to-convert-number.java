class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while(start > 0 || goal > 0){
            int t1 = start & 1;
            int t2 = goal & 1;
            if(t1 + t2 == 1)    count++;
            start = start >> 1;
            goal = goal >> 1;
        }
        if(start > 0){
            while(start > 0){
                int t1 = start & 1;
                if(t1 == 1) count++;
                start = start >> 1;
            }
        }
        if(goal > 0){
            while(goal > 0){
                int t1 = goal & 1;
                if(t1 == 1) count++;
                goal = goal >> 1;
            }
        }
        return count;
    }
}