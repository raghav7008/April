class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int x : nums)   sum += x;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum - curr - nums[i] == curr)    return i;
            curr += nums[i];
            //System.out.println(curr);
        }
        return -1;
    }
}