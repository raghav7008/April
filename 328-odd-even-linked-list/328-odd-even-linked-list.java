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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)   return head;
        ListNode head2 = head.next;
        ListNode ptr1 = head, ptr2 = head2;
        ListNode curr = head2.next;
        while(curr != null){
            //System.out.println(ptr1.val + " " + ptr2.val);
            ptr1.next = curr;
            ptr1 = ptr1.next;
            if(curr != null){   
                ptr2.next = curr.next;
                ptr2 = ptr2.next;
            }
            if(curr != null)    curr.next = null;
            if(ptr2 != null)   curr = ptr2.next;
            else    curr = null;
        }
        //ptr2.next = null;
        //while(head2 != null){ System.out.println(head2.val); head2 = head2.next;}
        ptr1.next = head2;
        return head;
    }
}