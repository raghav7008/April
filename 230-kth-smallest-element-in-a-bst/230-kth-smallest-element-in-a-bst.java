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
    //ArrayList<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
//     LinkedList<TreeNode> stack = new LinkedList<>();

//     while (true) {
//       while (root != null) {
//         stack.push(root);
//         root = root.left;
//       }
//       root = stack.pop();
//       if (--k == 0) return root.val;
//       root = root.right;
//     }
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        inorder(pq, root, k);
        return pq.poll();
  }
    public void inorder(PriorityQueue<Integer> pq, TreeNode root, int k){
        if(root == null)    return;
        inorder(pq, root.left, k);
        pq.add(root.val);
        if(pq.size() > k)   pq.poll();
        inorder(pq, root.right, k);
    }
}