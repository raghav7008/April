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
    int res = 0;
    HashSet<TreeNode> set = new HashSet<>();
    public int minCameraCover(TreeNode root) {
        set.add(null);
        dfs(root, null);
        return res;
    }
    public void dfs(TreeNode root, TreeNode parent){
        if(root != null){
            dfs(root.left, root);
            dfs(root.right, root);
        if(parent == null && !set.contains(root) || !set.contains(root.left) || !set.contains(root.right)){
            res++;
            set.add(parent);
            set.add(root);
            set.add(root.left);
            set.add(root.right);
        }
        }
    }
}