class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int end = nums.length - 1;
        while(left <= end){
            int mid = (left + end)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[left] || nums[mid] > nums[end]){
                if(target >= nums[left] && target < nums[mid]){
                    end = mid - 1;
                }
                else left = mid + 1;
            }
            else if(nums[mid] < nums[end] || nums[mid] < nums[left]){
                if(target > nums[mid] && target <= nums[end]){
                    left = mid + 1;
                }
                else end = mid - 1;
            }
            else    end--;
        }
        return -1;
    }
}