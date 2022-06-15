import java.util.*;
class Solution {
    public int minDeletions(String s) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq,0);
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        Arrays.sort(freq, Collections.reverseOrder());
        int count = 0;
        int max = s.length();
        for(int i = 0; i < 26; i++){
            if(freq[i] > max){
                count += freq[i] - max;
                freq[i] = max;
            }
             max = Math.max(0, freq[i] - 1);
        }
        return count;
    }
}