/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)    return result;
        q.add(root);
        boolean left = true;
        while(!q.isEmpty()){
            List<Integer> r = new ArrayList();
            if(left){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    TreeNode temp = q.poll();
                    r.add(temp.val);
                    if(temp.left != null)   q.add(temp.left);
                    if(temp.right != null)  q.add(temp.right);
                }
                left = false;
            }
            else{
                left = true;
                int size = q.size();
                Stack<Integer> st = new Stack<>();
                for(int i = 0; i < size; i++){
                    TreeNode temp = q.poll();
                    st.push(temp.val);
                    if(temp.left != null)   q.add(temp.left);
                    if(temp.right != null)  q.add(temp.right);
                }
                while(!st.isEmpty())    r.add(st.pop());
            }
            result.add(r);
        }
        return result;
    }
}