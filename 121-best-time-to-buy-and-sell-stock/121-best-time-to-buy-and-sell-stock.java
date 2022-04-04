class Solution {
    public int maxProfit(int[] nums) {
        int maxCurr = 0;
        int maxSofar = 0;
        for(int i = 1; i < nums.length ; i++){
            maxCurr = Math.max(0,maxCurr += nums[i] - nums[i-1]);
            maxSofar = Math.max(maxCurr,maxSofar);
        }
        return maxSofar;
    }
}