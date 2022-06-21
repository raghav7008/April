class Solution {
    public int calculate(String s) {
        s = s.replace(" ","");
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int temp = c - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    temp = temp * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                res += temp * sign;
            }
            else if(c == '+')   sign = 1;
            else if(c == '-')   sign = -1;
            else if(c == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if(c == ')'){
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}