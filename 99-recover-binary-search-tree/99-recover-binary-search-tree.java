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
    // ArrayList<TreeNode> in = new ArrayList<>();
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
    //     int p1 = 0;
    //     for(int i = 0; i < in.size() - 1; i++){
    //         if(in.get(i).val > in.get(i+1).val){
    //             p1 = i;
    //             i++;
    //             for(int j = 0; j < in.size() ; j++) System.out.println(in.get(j).val);
    //             while(i < in.size()){
    //                 if(in.get(p1).val > in.get(i).val)  i++;
    //                 else break;
    //             }
    //             if(i == in.size())  swap(in, p1, in.size()-1);
    //             else    swap(in, p1, i-1);
    //             break;
    //         }
    //     }
    // }
    // public void swap(ArrayList<TreeNode> in, int p1, int p2){
    //     int temp = in.get(p1).val;
    //     in.get(p1).val = in.get(p2).val;
    //     in.get(p2).val = temp;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void inorder(TreeNode root){
        if(root == null)    return;
        inorder(root.left);
        if(prev != null && root.val < prev.val){
            if(first == null)   first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}