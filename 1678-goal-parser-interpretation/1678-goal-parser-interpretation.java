class Solution {
    public String interpret(String command) {
        String res = "";
        int i = 0;
        while(i < command.length()){
            if(command.charAt(i) == 'G'){
                res += 'G';
                i++;
            }
            else if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                res += "o";
                i += 2;
            }
            else{
                res += "al";
                i += 4;
            }
        }
        return res;
    }
}