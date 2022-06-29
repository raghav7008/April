class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for(int[] x : people){
            list.add(x[1], new int[]{x[0], x[1]});
        }
        int[][] res = new int[people.length][2];
        int i = 0;
        for(int[] j : list){
            res[i][0] = j[0];
            res[i++][1] = j[1];
        }
        return res;
    }
}