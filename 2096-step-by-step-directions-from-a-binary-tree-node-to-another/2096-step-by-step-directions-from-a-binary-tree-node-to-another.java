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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> start = new ArrayList<>();
        List<String> dest = new ArrayList<>();
        TreeNode lca = findLCA(root, startValue, destValue);
        getDir(lca, startValue, start);
        getDir(lca, destValue, dest);
        // System.out.println(start.toString());
        // System.out.println(dest.toString());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < start.size(); i++){
            sb.append("U");
        }
        for(int i = 0; i < dest.size(); i++)    sb.append(dest.get(i));
        return sb.toString();
    }
    public TreeNode findLCA(TreeNode root, int s, int d){
        if(root == null || root.val == s || root.val == d)  return root;
        TreeNode left = findLCA(root.left, s, d);
        TreeNode right = findLCA(root.right, s, d);
        if(left != null && right != null)   return root;
        else if(left == null)   return right;
        else return left;
    }
    public boolean getDir(TreeNode root, int v, List<String> s){
        if(root == null)    return false;
        if(root.val == v)   return true;
        s.add("L");
        if(getDir(root.left, v, s)) return true;
        s.remove(s.size() - 1);
        s.add("R");
        if(getDir(root.right, v, s))    return true;
        s.remove(s.size()-1);
        return false;
    }
}