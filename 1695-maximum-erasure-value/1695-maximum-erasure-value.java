class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int start = 0, end = 0;
        int sum = 0;
        while(end < nums.length){
            if(!set.contains(nums[end])){
                set.add(nums[end]);
                sum += nums[end];
                max = Math.max(max, sum);
                end++;
            }
            else{
                while(start < nums.length && nums[start] != nums[end]){
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
                end++;
                max = Math.max(max,sum);
            }
            //System.out.println(end + " " + start + " " + sum);
        }
        return max;
    }
}