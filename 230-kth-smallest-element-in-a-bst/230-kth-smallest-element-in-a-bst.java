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
    int max = 0;
    int curr = 0;
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
        //PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        curr = k;
        inorder(root);
        return max;
  }
    public void inorder(TreeNode root){
        if(root == null)    return;
        inorder(root.left);
        if(--curr == 0){
            max = root.val;
            return;
        }
        inorder(root.right);
    }
}