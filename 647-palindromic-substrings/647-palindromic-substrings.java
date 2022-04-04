class Solution {
    private int count = 0;
    public int countSubstrings(String s) {
        int len = s.length();
	if (len < 2)
		return len;
	
    for (int i = 0; i < len; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return count;
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
        count += 1;
		j--;
		k++;
	}
	}
}