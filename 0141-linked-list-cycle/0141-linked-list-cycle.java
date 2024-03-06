/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slowCurr = head.next, fastCurr = head.next.next;
        while(fastCurr != null && fastCurr.next != null) {
            if(fastCurr == slowCurr) return true;
            fastCurr = fastCurr.next.next;
            slowCurr = slowCurr.next;
        }
        return false;
    }
}