/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)    return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            //System.out.println(size);
            for(int i = 0; i < size - 1; i++){
                Node temp = q.remove();
                temp.next = q.peek();
                if(temp.left != null)   q.add(temp.left);
                if(temp.right != null)  q.add(temp.right);
                //System.out.println(q.toString());
            }
            Node temp = q.remove();
            temp.next = null;
            if(temp.left != null)   q.add(temp.left);
            if(temp.right != null)  q.add(temp.right);
        }
        return root;
    }
}