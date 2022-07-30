class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList();
        int[] w2 = new int[26];
        for(String s : words2){
            int[] temp = new int[26];
            for(char c : s.toCharArray())   temp[c-'a']++;
            for(int i = 0; i < 26; i++) w2[i] = Math.max(w2[i], temp[i]);
        }
        for(String s : words1){
            int[] temp = new int[26];
            boolean flag = false;
            for(char c : s.toCharArray())   temp[c-'a']++;
            for(int i = 0; i < 26; i++){
                if(temp[i] < w2[i]){
                    flag = true;
                    break;
                }
            }
            if(!flag)   res.add(s);
        }
        return res;
    }
}