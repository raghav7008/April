class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        List<Integer> list = new ArrayList();
        int i = nums.length - 1;
        int carry = 0;
        while(k > 0 && i >= 0){
            int temp = k % 10;
            temp = temp + nums[i--] + carry;
            carry = temp/10;
            temp %= 10;
            list.add(temp);
            k /= 10;
            System.out.println(list.toString());
        }
        if(k > 0){
            while(k > 0){
                int temp = k % 10;
                temp += carry;
                carry = temp/10;
                temp %= 10;
                list.add(temp);
                k /= 10;
            }
        }
        if(i >= 0){
            while(i >= 0){
                int temp = nums[i--];
                temp += carry;
                carry = temp/10;
                temp %= 10;
                list.add(temp);
            }
        }
        if(carry == 1)  list.add(carry);
        Collections.reverse(list);
        return list;
    }
}