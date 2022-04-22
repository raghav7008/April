class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))  return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int changes = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                String word = queue.poll();
                if(word.equals(endWord))    return changes;
                for(int j = 0; j < word.length() ; j++){
                    for(int k = 'a' ; k <= 'z' ; k++){
                        char[] arr = word.toCharArray();
                        arr[j] = (char)k;
                        String temp = new String(arr);
                        if(set.contains(temp) && !visited.contains(temp)){
                            queue.add(temp);
                            visited.add(temp);
                        }
                    }
                }
            }
          ++changes;  
        }
        return 0;
    }
}