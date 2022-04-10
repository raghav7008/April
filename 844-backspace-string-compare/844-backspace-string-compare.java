class Solution {
    public boolean backspaceCompare(String s, String t) {
        String sCheck = "";
        String tCheck = "";
        for(int i = 0; i < s.length() ;  i++){
            if(s.charAt(i) == '#'){
                if(sCheck.length() > 0) sCheck = sCheck.substring(0,sCheck.length()-1);
            }
            else    sCheck += s.charAt(i);
        }
        for(int i = 0; i < t.length() ;  i++){
            if(t.charAt(i) == '#'){
                if(tCheck.length() > 0) tCheck = tCheck.substring(0,tCheck.length()-1);
            }
            else    tCheck += t.charAt(i);
        }
        return sCheck.equals(tCheck);
    }
}