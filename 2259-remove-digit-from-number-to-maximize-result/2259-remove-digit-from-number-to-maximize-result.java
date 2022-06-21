class Solution {
    public String removeDigit(String number, char digit) {
        int last = 0;
        for(int i= 0 ; i < number.length() - 1; i++){
            if(number.charAt(i) == digit && number.charAt(i+1) > number.charAt(i)){
                return number.substring(0,i) + number.substring(i+1);
            }
            if(number.charAt(i) == digit)   last = i;
        }
        last = number.charAt(number.length()-1) == digit ? number.length() - 1 : last;
        if(last == number.length() - 1)   return number.substring(0,number.length()-1);
        return number.substring(0,last) + number.substring(last+1);
    }
}