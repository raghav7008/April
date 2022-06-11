class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product = 1;
        for(int i = 0; i < nums.length; i++){
                        product = (product == 0 ? 1 : product) * nums[i];

            max = Math.max(max, product);
        }
        product = 1;
        //System.out.println(max);
        for(int i = nums.length - 1; i >= 0; i--){
            product = (product == 0 ? 1 : product) * nums[i];
            max = Math.max(max, product);
        }
        //System.out.println(max);
        
        return max;
    }
}