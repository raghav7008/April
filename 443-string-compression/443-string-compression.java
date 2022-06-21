class Solution {
    public int compress(char[] chars) {
        int index = 0, idx = 0;
        while(idx < chars.length){
            char c = chars[idx];
            int count = 0;
            while(idx < chars.length && chars[idx] == c){
                idx++;
                count++;
            }
            chars[index++] = c;
            if(count != 1)
                for(char t : Integer.toString(count).toCharArray()) 
                    chars[index++] = t;
        }
        return index;
    }
}