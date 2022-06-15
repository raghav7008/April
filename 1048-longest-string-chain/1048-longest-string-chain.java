class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a,b) -> a.length()- b.length());
        int res = 0;
        for(int i = 0; i < words.length; i++){
            int best = 0;
            for(int j = 0; j < words[i].length(); j++){
                String s = words[i].substring(0,j) + words[i].substring(j+1);
                best = Math.max(best, map.getOrDefault(s,0) + 1);
            }
            map.put(words[i], best);
            res = Math.max(res, best);
        }
        return res;
    }
}