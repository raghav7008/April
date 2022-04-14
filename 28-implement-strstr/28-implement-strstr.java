class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)    return 0;
        int idx = -1;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if(needle.equals(haystack.substring(i,needle.length() + i))){
                idx = i;
                break;
            }
        }
        return idx;
    }
}