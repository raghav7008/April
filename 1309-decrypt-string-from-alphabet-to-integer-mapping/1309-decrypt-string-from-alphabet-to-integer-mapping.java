class Solution {
    public String freqAlphabets(String s) {
        int i = s.length() - 1;
        String res = "";
        while(i >= 0){
            if(s.charAt(i) == '#'){
                String t = "";
                t += s.charAt(i-2);
                t += s.charAt(i-1);
                int temp = Integer.valueOf(t) ;
                //System.out.println(temp);
                res = (char)(temp + 'a' - 1) + res;
                i -= 3;
            }
            else{
                res = (char)(Integer.valueOf(s.charAt(i)) + 'a' - '0' - 1) + res;
                i--;
            }
        }
        return res;
    }
}