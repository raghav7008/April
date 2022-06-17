class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length > 6 * nums2.length || nums2.length > 6 * nums1.length)  return -1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < nums1.length; i++)   sum1 += nums1[i];
        for(int i = 0; i < nums2.length; i++)   sum2 += nums2[i];
        if(sum1 > sum2) return minOperations(nums2, nums1);
        int i = 0, j = nums2.length - 1, operations = 0;
        while (sum2 > sum1) {

            if (j < 0 || i < nums1.length && 6 - nums1[i] > nums2[j] - 1) {
                sum1 += 6 - nums1[i++]; 
            }else {
                sum2 -= nums2[j--] - 1;
            }
            ++operations;
        }
        return operations;
    }
}