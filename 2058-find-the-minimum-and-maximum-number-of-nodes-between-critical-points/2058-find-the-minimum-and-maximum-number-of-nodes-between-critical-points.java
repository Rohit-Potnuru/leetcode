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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int prevCriticalPt = -1, firstCriticalPt = -1, minCriticalPt = Integer.MAX_VALUE;
        int prev = head.val, i = 0;
        ListNode curr = head;
        while(curr.next != null) {
            if((prev > curr.val && curr.next.val > curr.val) ||
               (prev < curr.val && curr.next.val < curr.val)) {
                if(prevCriticalPt == -1) {
                    firstCriticalPt = i;
                }
                else {
                    minCriticalPt = Math.min(minCriticalPt, i - prevCriticalPt);
                }
                prevCriticalPt = i;
               }
            i++;
            prev = curr.val;
            curr = curr.next;
        }
        int maxCriticalPt = prevCriticalPt - firstCriticalPt;
        maxCriticalPt = (maxCriticalPt == 0) ? -1 : maxCriticalPt;
        minCriticalPt = (minCriticalPt == Integer.MAX_VALUE) ? -1 : minCriticalPt;
        return new int[]{minCriticalPt, maxCriticalPt};
    }
}