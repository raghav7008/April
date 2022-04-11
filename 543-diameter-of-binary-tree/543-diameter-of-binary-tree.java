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
// class Solution {
//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null)    return 0;
//         int dia = depth(root.left) + depth(root.right);
//         int left = diameterOfBinaryTree(root.left);
//         int right = diameterOfBinaryTree(root.right);
//         return Math.max(dia,Math.max(left,right));
//     }
//     public int depth(TreeNode node){
//         if(node == null)    return 0;
//         return 1 + Math.max(depth(node.left),depth(node.right));
//     }
// }

public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max-1;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int temp = 1 + Math.max(left,right);
        int ans = Math.max(temp,left+right+1);
        max = Math.max(ans,max);
        return temp;
    }
}