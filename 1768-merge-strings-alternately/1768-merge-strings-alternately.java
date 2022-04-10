class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        boolean flag = true;
        String res = "";
        while(i < word1.length() && j < word2.length()){
            if(flag){
                res += word1.charAt(i);
                i++;
                flag = false;
            }
            else{
                res += word2.charAt(j);
                j++;
                flag = true;
            }
        }
        if(i != word1.length()){
            while(i < word1.length()){
                res += word1.charAt(i);
                i++;
            }
            return res;
        }
        if(j != word2.length()){
            while(j < word2.length()){
                res += word2.charAt(j);
                j++;
            }
            
        }
        return res;
    }
}