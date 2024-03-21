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
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode nextCurr = head.next;
        ListNode nextNextCurr = head.next.next;
        curr.next = null;
        while(nextCurr != null) {
            nextCurr.next = curr;

            curr = nextCurr;
            nextCurr = nextNextCurr;
            if(nextNextCurr != null) {
                nextNextCurr = nextNextCurr.next;
            }
        }
        return curr;
    }
}