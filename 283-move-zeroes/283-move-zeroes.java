class Solution {
    public void moveZeroes(int[] nums) {
        int l = nums.length;
        int[] arr = new int[l];
        for(int i = 0 ; i < l ; i++){
            arr[i] = 0;
        }
        int j = 0;
        for(int i = 0; i < l; i++){
            if(nums[i] != 0){
                arr[j] = nums[i];
                j++;
            }
        }
        for(int i = 0; i < l ; i++){
            nums[i] = arr[i];
        }
        return;
    }
}