class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] TtoS = new int[256];
        int[] StoT = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(TtoS[s.charAt(i)] != StoT[t.charAt(i)])  return false;
            TtoS[s.charAt(i)] = i + 1;
            StoT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}