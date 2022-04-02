class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)    return nums[0];
        int curr = Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length ; i++){
            if(curr < 0)    curr = nums[i];
            else curr += nums[i];
            maxi = Math.max(maxi,curr);
        }
        return maxi;
    }
}