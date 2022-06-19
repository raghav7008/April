class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.startingWith(prefix));
        }
        return result;
    }
}
class Trie{
    class Node{
        boolean end = false;
        List<Node> links = Arrays.asList(new Node[26]);
    }
    Node root, curr;
    List<String> res;
    Trie(){
        root = new Node();
    }
    void insert(String s){
        curr = root;
        for(char x : s.toCharArray()){
            if(curr.links.get(x-'a') == null)   curr.links.set(x-'a', new Node());
            curr = curr.links.get(x-'a');
        }
        curr.end = true;
    }
    List<String> startingWith(String prefix){
        curr = root;
        res = new ArrayList<String>();
        for(char x : prefix.toCharArray()){
            if(curr.links.get(x-'a') == null)   return res;
            curr = curr.links.get(x-'a');
        }
        helper(curr, prefix);
        return res;
    }
    void helper(Node curr, String word){
        if(res.size() == 3) return;
        if(curr.end) res.add(word);
        for(char x = 'a'; x <= 'z'; x++){
            if(curr.links.get(x-'a') != null)   helper(curr.links.get(x-'a'), word + x);
        }
    }
}