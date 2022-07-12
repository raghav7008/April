class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int x : matchsticks)    sum += x;
        if(sum % 4 != 0)    return false;
        sum /= 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return helper(matchsticks, 0, new int[4], sum);
    }
    public boolean helper(int[] nums, int idx, int[] sum, int tar){
        if(idx == nums.length){
            if(sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3])  return true;
            return false;
        }
        for(int i = 0; i < 4; i++){
            if(sum[i] + nums[idx] > tar)    continue;
            sum[i] += nums[idx];
            if(helper(nums, idx + 1, sum, tar)) return true;
            sum[i] -= nums[idx];
        }
        return false;
    }
    public void reverse(int[] nums){
        int i = 0, j = nums.length - 1;
        while(i < j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}