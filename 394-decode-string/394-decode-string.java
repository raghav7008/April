class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> res = new Stack<>();
        int idx = 0;
        String str = "";
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int c = 0;
                while(Character.isDigit(s.charAt(idx))){
                    c = 10 * c + (s.charAt(idx++) - '0');
                }
                count.push(c);
            }
            else if(s.charAt(idx) == '['){
                res.push(str);
                str = "";
                idx++;
            }
            else if(s.charAt(idx) == ']'){
                StringBuilder sb = new StringBuilder(res.pop());
                int t = count.pop();
                for(int i = 0; i < t; i++){
                    sb.append(str);
                }
                str = sb.toString();
                idx++;
            }
            else    str += s.charAt(idx++);
        }
        return str;
    }
}