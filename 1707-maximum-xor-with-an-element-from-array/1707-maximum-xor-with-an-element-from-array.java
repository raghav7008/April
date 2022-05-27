class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> q = new ArrayList();
        for(int i = 0; i < queries.length; i++){
            ArrayList<Integer> temp = new ArrayList();
            temp.add(queries[i][0]);
            temp.add(queries[i][1]);
            temp.add(i);
            q.add(temp);
        }
        Collections.sort(q, new Comparator<ArrayList<Integer>> () {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(1).compareTo(b.get(1));
            }
        });
        int res[] = new int[queries.length];
        Trie t = new Trie();
        int ind = 0, n = nums.length;
        for(int i = 0; i < queries.length; i++){
            while(ind < n && nums[ind] <= q.get(i).get(1)){
                t.insert(nums[ind]);
                ind++;
            }
            int queryInd = q.get(i).get(2); 
            if(ind!=0) res[queryInd] = t.getMax(q.get(i).get(0));
            else res[queryInd] = -1; 
        }
        return res;
    }
}
class Node{
    Node links[] = new Node[2];
    Node(){}
    boolean contains(int ind){
        return (links[ind] != null);
    }
    void put(int ind, Node n){
        links[ind] = n;
    }
    Node get(int ind){
        return links[ind];
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    public void insert(int num){
        Node node = root;
        for(int i = 31; i >= 0; i--){
            int bit = (num >>> i) & 1;
            if(!node.contains(bit)) node.put(bit, new Node());
            node = node.get(bit);
        }
    }
    public int getMax(int num){
        Node node = root;
        int max = 0;
        for(int i = 31; i>= 0; i--){
            int bit = (num >>> i) & 1;
            if(node.contains(1 - bit)){
                max += (1 << i);
                node = node.get(1 - bit);
            }
            else    node = node.get(bit);
        }
        return max;
    }
}