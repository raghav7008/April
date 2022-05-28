class Solution {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] > nums.length - 1)   continue;
            if(nums[i] == i)    continue;
            int temp = nums[i];
            int ind1 = nums[i];
            int ind2 = i;
            nums[ind2] = nums[ind1];
            nums[ind1] = temp;
            i--;
        }
        
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] != i)    return i;
        }
        return nums[nums.length-1]+1;
    }
}