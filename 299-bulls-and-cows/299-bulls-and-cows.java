class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < secret.length() ; i++){
            if(secret.charAt(i) == guess.charAt(i)) bulls++;
            else{
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i),0) + 1);
            }
        }
        for(int i = 0; i < guess.length(); i++){
            if(secret.charAt(i) != guess.charAt(i)){
                if(map.containsKey(guess.charAt(i))){
                    cows++;
                    if(map.get(guess.charAt(i)) == 1)   map.remove(guess.charAt(i));
                    else    map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                }
            }
        }
        String res = bulls + "A" + cows + "B";
        return res;
    }
}