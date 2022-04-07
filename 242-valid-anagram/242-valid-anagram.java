class Solution {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length())    return false;
        int[] ch = new int[26];
        for(int i = 0; i < s.length() ; i++){
            ch[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < t.length() ; i++){
            ch[t.charAt(i)-'a']--;
            if(ch[t.charAt(i) - 'a'] < 0)   return false;
        }
        return true;
    }
}