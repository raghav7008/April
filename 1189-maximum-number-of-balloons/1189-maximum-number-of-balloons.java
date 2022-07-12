class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[5];
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == 'b')   freq[0]++;
            else if(text.charAt(i) == 'a')   freq[1]++;
            else if(text.charAt(i) == 'l')   freq[2]++;
            else if(text.charAt(i) == 'o')   freq[3]++;
            else if(text.charAt(i) == 'n')   freq[4]++;
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(freq[0], min);
        min = Math.min(freq[1], min);
        min = Math.min(freq[2]/2, min);
        min = Math.min(freq[3]/2, min);
        min = Math.min(freq[4], min);
        return min;
    }
}