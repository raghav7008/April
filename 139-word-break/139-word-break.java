class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for(String str : wordDict)    set.add(str);
        f[0] = true;
        for(int i = 1; i <= s.length() ; i++){
            for(int j = 0; j < i ; j++){
                if(f[j] && set.contains(s.substring(j,i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}