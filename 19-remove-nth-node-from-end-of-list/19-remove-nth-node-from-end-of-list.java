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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode ptr = head;
        while(ptr != null){
            count++;
            ptr = ptr.next;
        }
        if(count == n){
            return head.next;
        }
        count -= n;
        ptr = head;
        for(int i = 0; i < count - 1; i++){
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        return head;
    }
}