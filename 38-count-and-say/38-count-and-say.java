class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = helper(s);
        }
        return s;
    }
    public String helper(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(c == s.charAt(i))    count++;
            else{
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}