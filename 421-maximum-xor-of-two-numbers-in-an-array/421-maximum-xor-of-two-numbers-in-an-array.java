class Solution {
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for(int num : nums){
            Node node = root;
            for(int i = 31; i >= 0; i--){
                int bit = (num >>> i) & 1;
                if(!node.contains(bit)) node.put(bit, new Node());
                node = node.get(bit);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            int curSum = 0;
            Node node = root;
            for(int i = 31; i >= 0; i--){
                int bit = (num >>> i) & 1;
                if(node.contains(1 - bit)){
                    node = node.get(1 - bit);
                    curSum += (1 << i);
                }
                else    node = node.get(bit);
            }
            max = Math.max(max,curSum);
        }
        return max;
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