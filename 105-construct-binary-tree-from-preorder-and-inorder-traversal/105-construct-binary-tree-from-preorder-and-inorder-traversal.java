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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    public TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, HashMap<Integer,Integer> map){
        if(ps > pe || is > ie)  return null;
        TreeNode temp = new TreeNode(preorder[ps]);
        int r = map.get(preorder[ps]);
        int left = r - is;
        temp.left = helper(preorder, ps + 1, ps + left, inorder, is, r - 1, map);
        temp.right = helper(preorder, ps + left + 1, pe, inorder, r + 1, ie, map);
        return temp;
    }
}