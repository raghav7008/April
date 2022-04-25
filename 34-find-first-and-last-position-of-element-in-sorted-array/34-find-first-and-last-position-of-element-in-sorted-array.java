class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int[] arr = new int[]{-1,-1};
        if(nums.length == 0)    return arr;
        while(lo < hi){
            int mid = (lo+hi)/2;
            if(nums[mid] < target) lo = mid + 1;
            else    hi = mid;
        }
        if(nums[lo] != target)    return arr;
        arr[0] = lo;
        lo = 0;
        hi = nums.length-1;
        while(lo < hi){
            int mid = (lo+hi)/2 + 1;
            if(nums[mid] > target) hi = mid - 1;
            else    lo = mid;
        }
        arr[1] = hi;
        return arr;
    }
}