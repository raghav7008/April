/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        findDistance(root, target, k, res);
        return res;
    }
    public int findDistance(TreeNode root, TreeNode tar, int k, List<Integer> res){
        if(root == null)    return -1;
        if(root == tar){
            getDownNodes(root, k, res);
            return 1;
        }
        int d1 = findDistance(root.left, tar, k, res);
        if(d1 >= 0){
            if(d1 == k){
                res.add(root.val);
            }
            else{
                getDownNodes(root.right, k - d1 - 1, res);
            }
            return d1 + 1;
        }
        int d2 = findDistance(root.right, tar, k, res);
        if(d2 >= 0){
            if(d2 == k){
                res.add(root.val);
            }
            else{
                getDownNodes(root.left, k - d2 - 1, res);
            }
            return d2 + 1;
        }
        return -1;
    }
    public void getDownNodes(TreeNode node, int k, List<Integer> res){
        if(node == null)    return;
        if(k == 0){
            res.add(node.val);
            return;
        }
        getDownNodes(node.left, k - 1, res);
        getDownNodes(node.right, k - 1, res);
    }
}