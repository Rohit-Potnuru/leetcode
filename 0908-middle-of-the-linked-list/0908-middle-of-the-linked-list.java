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
    public ListNode middleNode(ListNode head) {
        ListNode slowCurr = head, fastCurr = head;
        while(fastCurr != null && fastCurr.next != null) {
            slowCurr = slowCurr.next;
            fastCurr = fastCurr.next.next;
        }
        return slowCurr;
    }
}