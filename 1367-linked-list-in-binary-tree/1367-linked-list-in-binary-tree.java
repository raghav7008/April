/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean check = false;
            for(int i = 0; i < size ; i++){
                TreeNode temp = q.poll();
                if(temp.val == head.val){
                    check = dfs(head, temp);
                    if(check)   return true;
                }
                if(temp.left != null)   q.add(temp.left);
                if(temp.right != null)   q.add(temp.right);
            }
        }
        return false;
    }
    public boolean dfs(ListNode head, TreeNode root){
        if(head == null)    return true;
        if(root == null)    return false;
        if(root.val != head.val)    return false;
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}