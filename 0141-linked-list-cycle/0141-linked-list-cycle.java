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
        ListNode slowCurr = head, fastCurr = head;
        while(fastCurr != null && fastCurr.next != null) {
            fastCurr = fastCurr.next.next;
            slowCurr = slowCurr.next;
            if(fastCurr == slowCurr) return true;
        }
        return false;
    }
}