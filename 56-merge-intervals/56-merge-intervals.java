class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            list.add(intervals[i][0]);
            int end = intervals[i][1];
            int temp = intervals[i][0];
            while(end >= temp && i < intervals.length){
                end = Math.max(end,intervals[i][1]);
                if(i + 1 < intervals.length)    temp = intervals[i+1][0];
                i++;
            }
            list.add(end);
            i--;
        }
        int[][] result = new int[list.size()/2][2];
        int k = 0;
        for(int i = 0; i < list.size()/2 ; i++){
            for(int j = 0; j < 2 ; j++){
                result[i][j] = list.get(k);
                k++;
            }
        }
        return result;
    }
}