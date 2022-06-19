class Solution {
    public String strWithout3a3b(int A, int B) {
        String s = "";
        while(A != 0 && B!= 0){
            s = s +"a"+"b";
            A--;
            B--;
        }
        if(A != 0){
            s = s + "a";
            A--;
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<s.length();i++){
                sb.append(s.charAt(i));
                if(A > 0 && s.charAt(i) == 'a'){
                    sb.append('a');
                    A--;
                }
            }
            return sb.toString();
        }
        if(B != 0){
            s = "b" + s;
            B--;
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<s.length();i++){
                sb.append(s.charAt(i));
                if(B > 0 && s.charAt(i) == 'b'){
                    sb.append('b');
                    B--;
                }
            }
            return sb.toString();
        }
        return s;
    }
}