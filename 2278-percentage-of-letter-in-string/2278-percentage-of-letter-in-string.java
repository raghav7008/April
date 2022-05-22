class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.compare(s.charAt(i),letter) == 0)   count++;
        }
        return (count * 100) /s.length();
    }
}