class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList();
        for(int i = 0; i < l.length; i++){
            result.add(helper(nums, l[i], r[i]));
        }
        return result;
    }
    public boolean helper(int[] nums, int start, int end){
        if(end - start < 2) return true;
        Set<Integer> set = new HashSet<Integer>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++){
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if((max - min)%(end-start) != 0)    return false;
        int t = (max - min) / (end - start);
        for(int i = 1; i <= end - start; i++){
            if(!set.contains(min + i * t))  return false;
        }
        return true;
    }
}