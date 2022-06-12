class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int max = 0;
        int maxFreq = 0;
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(i) - 'A']);
            int toChange = i - left + 1 - maxFreq;
            if(toChange > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}