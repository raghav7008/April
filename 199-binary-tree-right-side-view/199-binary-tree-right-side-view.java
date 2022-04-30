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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
     if(root == null){
         return al;
     }
     Queue<TreeNode> q = new LinkedList<>();
     q.offer(root);
     
     while(!q.isEmpty()){
         int size = q.size();
         
         for(int i=0; i<size; i++){
             TreeNode temp = q.poll();
             
             if(temp.left != null){
                 q.offer(temp.left);
             }
             if(temp.right != null){
                 q.offer(temp.right);
             }
             
             if(i == size - 1){
                 al.add(temp.val);
             }
         }
     }
     
     return al;
    }
}