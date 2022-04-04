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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        while(k > 1){
            fast = fast.next;
            k--;   
        }
        ListNode temp = fast;
        ListNode slow = head;
        while(temp.next != null){
            slow = slow.next;
            temp = temp.next;
        }
        int first = slow.val;
        slow.val = fast.val;
        fast.val = first;
        return head;
    }
}