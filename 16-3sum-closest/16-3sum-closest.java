class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int curr = 0;
        int diff = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int lo = i+1;
            int hi = nums.length - 1;
            while(lo < hi){
                curr = nums[i]+nums[lo]+nums[hi];
                if(curr == target) return target;
                if(curr < target){
                    lo++;
                }
                else if(curr > target){
                    hi--;
                }
                if(Math.abs(curr-target) < diff){
                    min = curr;
                    diff = Math.abs(curr - target);
                }
            }
        }
        return min;
    }
}