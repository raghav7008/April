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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // if(root == null)    return new ArrayList<List<Integer>>();
        // Queue<TreeNode> q1 = new LinkedList<>();
        // Queue<TreeNode> q2 = new LinkedList<>();
        // List<List<Integer>> result = new ArrayList();
        // q1.add(root);
        // while(!q1.isEmpty() || !q2.isEmpty()){
        //     List<Integer> res = new ArrayList();
        //     while(!q1.isEmpty()){
        //         TreeNode temp = q1.remove();
        //         res.add(temp.val);
        //         if(temp.left != null)   q2.add(temp.left);
        //         if(temp.right != null)  q2.add(temp.right);
        //     }
        //     //System.out.println(res.toString());
        //     if(res.size() > 0)  result.add(new ArrayList(res));
        //     //System.out.println(result.get(0).toString());
        //     res.clear();
        //     while(!q2.isEmpty()){
        //         TreeNode temp = q2.remove();
        //         res.add(temp.val);
        //         if(temp.left != null)   q1.add(temp.left);
        //         if(temp.right != null)  q1.add(temp.right);
        //     }
        //     if(res.size() > 0) result.add(res);
        // }
        // return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}