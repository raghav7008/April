class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i] += carry;
            if(digits[i] == 10){
                digits[i] = 0;
                carry = 1;
            }
            else return digits;
        }
        if(carry == 1){
            int[] res = new int[digits.length+1];
            Arrays.fill(res,0);
            res[0] = 1;
            return res;
        }
        return digits;
    }
}