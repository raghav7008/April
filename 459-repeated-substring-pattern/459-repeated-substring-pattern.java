class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1) return false;
        int len = s.length();
        for(int i = len/2; i >= 1; i--){
            if(len % i == 0){
                StringBuilder str = new StringBuilder(s.substring(0,i));
                String temp = s.substring(0,i);
                while(str.length() != len)  str.append(temp);
                if(s.equals(str.toString()))    return true;
            }
        }
        return false;
    }
}