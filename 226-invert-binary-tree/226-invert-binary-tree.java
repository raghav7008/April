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
    public TreeNode invertTree(TreeNode node) {
        if(node == null)    return node;
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        if(node.left != null)   invertTree(node.left);
        if(node.right != null)  invertTree(node.right);
        return node;
    }
}