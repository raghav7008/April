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
    public void reorderList(ListNode head) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode ptr = head;
        int i = 1;
        while(ptr != null){
            map.put(i,ptr);
            ptr = ptr.next;
            i++;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int j = 0;
        for(i = 1, j = map.size(); i <= j; i++, j--){
            curr.next = map.get(i);
            if(i != j)  map.get(i).next = map.get(j);
            map.get(j).next = null;
            curr = map.get(j);
        }
    }
}