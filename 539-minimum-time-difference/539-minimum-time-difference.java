class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] avail = new boolean[1440];
        for(int i = 0; i < timePoints.size(); i++){
            String[] s = timePoints.get(i).split(":");
            int h = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            if(avail[(h* 60) + m])  return 0;
            avail[(h* 60) + m] = true;
        }
        int first = Integer.MAX_VALUE;
        int prev = 0;
        int last = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 1440; i++){
            if(avail[i]){
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        min = Math.min(min, (1440 - last + first));
        return min;
    }
}