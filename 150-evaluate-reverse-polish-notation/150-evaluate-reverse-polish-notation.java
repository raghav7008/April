class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length ; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                if(tokens[i].equals("+"))   stack.push(op1+op2);
                else if(tokens[i].equals("-"))   stack.push(op1-op2);
                else if(tokens[i].equals("*"))   stack.push(op1*op2);
                else   stack.push(op1/op2);
            }
            else    stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }
}