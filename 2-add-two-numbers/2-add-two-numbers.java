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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode ptr3 = dummy;
        while(ptr1 != null && ptr2 != null){
            int temp = ptr1.val + ptr2.val + carry;
            if(temp > 9){
                carry = 1;
                temp = temp - 10;
            }
            else    carry = 0;
            ListNode n = new ListNode(temp);
            ptr3.next = n;
            ptr3 = n;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        if(ptr1 != null){
            while(ptr1 != null){
            int temp = ptr1.val + carry;
            if(temp > 9){
                carry = 1;
                temp = temp - 10;
            }
            else carry = 0;
            ListNode n = new ListNode(temp);
            ptr3.next = n;
            ptr3 = n;
            ptr1 = ptr1.next;
            } 
        }
        if(ptr2 != null){
            while(ptr2 != null){
            int temp = ptr2.val + carry;
            if(temp > 9){
                carry = 1;
                temp = temp - 10;
            }
            else carry = 0;
            ListNode n = new ListNode(temp);
            ptr3.next = n;
            ptr3 = n;
            ptr2 = ptr2.next;
            } 
        }
        if(carry == 1){
            ListNode n = new ListNode(carry);
            ptr3.next = n;
            ptr3 = n;
        }
        return dummy.next;
    }
}