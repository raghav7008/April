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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = null, head2 = null, curr1 = null, curr2 = null, curr = head;
        while(curr != null){
            if(curr.val < x){
                if(head1 == null){
                    head1 = curr;
                    curr1 = curr;
                }
                else{
                    curr1.next = curr;
                    curr1 = curr1.next;
                }
                curr = curr.next;
                curr1.next = null;
            }
            else{
                if(head2 == null){
                    head2 = curr;
                    curr2 = curr;
                }
                else{
                    curr2.next = curr;
                    curr2 = curr2.next;
                }
                curr = curr.next;
                curr2.next = null;
            }
        }
        if(curr1 != null)   curr1.next = head2;
        else return head2;
        return head1;
    }
}