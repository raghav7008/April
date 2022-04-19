class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] nums2 = new int[nums.length];
        nums2[0] = 1;
        int j = 0;
        for(int i = 1; i < nums.length ; i++){
            nums2[i] = nums2[i-1]*nums[j];
            j++;
        }
        int temp = 1;
        for(int i = nums.length - 1; i >= 0 ; i--){
            nums2[i] *= temp;
            temp *= nums[i];
        }
        return nums2;
    }
}