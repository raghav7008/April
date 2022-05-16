/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode ptr1 = headA, ptr2 = headB;
        while(ptr1 != null){
            lenA++;
            ptr1 = ptr1.next;
        }
        while(ptr2 != null){
            lenB++;
            ptr2 = ptr2.next;
        }
        if(lenA >= lenB){
            int diff = lenA- lenB;
            ptr1 = headA;
            while(diff > 0){
                ptr1 = ptr1.next;
                diff--;
            }
            ptr2 = headB;
            while(ptr1 != null && ptr2 != null && ptr1 != ptr2){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        }
        else{
            int diff = lenB- lenA;
            ptr1 = headA;
            ptr2 = headB;
            while(diff > 0){
                ptr2 = ptr2.next;
                diff--;
            }
            while(ptr1 != null && ptr2 != null && ptr1 != ptr2){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        }
    }
}