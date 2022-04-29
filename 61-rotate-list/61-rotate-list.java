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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)    return head;
        if(k == 0)  return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode ptr = head;
        while(ptr.next != null){
            len++;
            ptr = ptr.next;
        }
        len++;
        
        k %= len;
        k = len - k;
        ListNode ptr2 = head;
        ListNode prev = null;
        while(k != 0){
            k--;
            prev = ptr2;
            ptr2 = ptr2.next;
        }
        //System.out.println(ptr2.val);
        ptr.next = dummy.next;
        dummy.next = prev.next;
        prev.next = null;
        return dummy.next;
    }
}