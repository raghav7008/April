class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int ans = 0;
        int i = 0;
        while(truckSize > 0 && i < boxTypes.length){
            if(truckSize >= boxTypes[i][0]){
                ans += boxTypes[i][1] * boxTypes[i][0];
                truckSize -= boxTypes[i][0];
                i++;
            }
            else{
                while(truckSize > 0){
                    ans += boxTypes[i][1];
                    truckSize--;
                }
            }
        }
        return ans;
    }
}