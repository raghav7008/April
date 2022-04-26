class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[n - 1] - nums[0];
        for(int i = 0; i < n - 1; i++){
            int t1 = nums[i], t2 = nums[i+1];
            int hi = Math.max(t1 + k, nums[n-1] - k);
            int lo = Math.min(t2 - k, nums[0] + k);
            ans = Math.min(ans, hi - lo);
        }
        return ans;
    }
}