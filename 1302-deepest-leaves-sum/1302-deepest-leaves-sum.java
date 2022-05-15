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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)    return 0;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<Pair<TreeNode,Integer>>();
        ArrayList<Pair<TreeNode,Integer>> list = new ArrayList();
        q.offer(new Pair(root, 1));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair temp = q.remove();
                TreeNode node = (TreeNode)temp.getKey();
                int level = (int)temp.getValue();
                list.add(new Pair(node, level));
                if(node.left != null)   q.offer(new Pair(node.left, level + 1));
                if(node.right != null)   q.offer(new Pair(node.right, level + 1));
                //System.out.println(node.val + " " + level);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            max = Math.max(max, list.get(i).getValue());
        }
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getValue() == max){
                sum += list.get(i).getKey().val;
            }
        }
        return sum;
    }
}
// class Pair{
//     TreeNode node;
//     int level;
//     Pair(TreeNode node, int level){
//         this.node = node;
//         this.level = level;
//     }
// }