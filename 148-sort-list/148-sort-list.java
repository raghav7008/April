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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode ptr = head;
        while(ptr != null){
            list.add(ptr.val);
            ptr = ptr.next;
        }
        Collections.sort(list);
        ptr = head;
        int i = 0;
        while(ptr != null){
            ptr.val = list.get(i++);
            ptr = ptr.next;
        }
        return head;
    }
}