class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1)    return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i])    j--;
            swap(i,j,nums);
        }
        reverse(nums,i+1);
    }
    public void swap(int idx1, int idx2, int[] nums){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}