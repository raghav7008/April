class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length() ; i++){
            freq[s.charAt(i) - 'a']++;
        }
        int max = Integer.MIN_VALUE;
        char c = 'a';
        for(int i = 0; i < 26; i++){
            if(freq[i] > max){
                max = freq[i];
                c = (char)(i + 'a');
            }
        }
        if(max > (s.length() + 1) / 2)  return "";
        char[] charArray = new char[s.length()];
        int idx = 0;
        while(freq[c - 'a'] > 0){
            charArray[idx] = c;
            idx += 2;
            freq[c - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            while(freq[i] > 0){
                if(idx >= s.length())   idx = 1;
                charArray[idx] = (char)(i + 'a');
                idx += 2;
                freq[i]--;
            }
        }
        return String.valueOf(charArray);
    }
}