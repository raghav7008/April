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
    TreeNode ans,temp;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode curr = new TreeNode(-1);
        ans = curr;
        temp = curr;
        inorder(root);
        return temp.right;
    }
    public void inorder(TreeNode root){
        if(root == null)    return;
        inorder(root.left);
        ans.right = root;
        ans = root;
        root.left = null;
        inorder(root.right);
    }
}