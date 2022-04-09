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
    public ListNode reverseList(ListNode head) {
        if(head == null)    return head;
        ListNode n = new ListNode();
        while(head != null){
            ListNode temp = new ListNode(head.val);
            temp.next = n;
            n = temp;
            head = head.next;
        }
        ListNode ptr = n;
        while(ptr.next.next != null){
            ptr = ptr.next;
        }
        ptr.next = null;
        return n;
    }
}