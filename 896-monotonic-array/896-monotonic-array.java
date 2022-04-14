class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1)    return true;
        boolean r1 = false, r2 = false;
        for(int i = 0; i < nums.length -1 ; i++){
            if(nums[i] <= nums[i+1])    r1 = true;
            else{
                r1 = false;
                break;
            }
        }
        for(int i = 0; i < nums.length -1 ; i++){
            if(nums[i] >= nums[i+1])    r2 = true;
            else{
                r2 = false;
                break;
            }
        }
        return r1 || r2;
    }
}