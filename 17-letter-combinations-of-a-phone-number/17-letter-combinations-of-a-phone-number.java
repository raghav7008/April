class Solution {
    public String[] mapping = {"", "" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)    return new ArrayList<String>();
        combinations("", digits, 0);
        return result;
    }
    public void combinations(String pre, String digits, int curr){
        if(curr == digits.length()){
            result.add(pre);
            return;
        }
        String l = mapping[digits.charAt(curr) - '0'];
        for(int i = 0; i < l.length() ; i++){
            combinations(pre+l.charAt(i), digits, curr+1);
        }
    }
}