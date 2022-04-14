class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1)    return true;
        boolean r1 = true, r2 = true;
        for(int i = 0; i < nums.length -1 ; i++){
            if(nums[i] <= nums[i+1])    continue;
            else{
                r1 = false;
                break;
            }
        }
        for(int i = 0; i < nums.length -1 ; i++){
            if(nums[i] >= nums[i+1])   continue;
            else{
                r2 = false;
                break;
            }
        }
        return r1 || r2;
    }
}