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
    public ListNode mergeNodes(ListNode head) {
        ListNode start = new ListNode(-1, head), prevZero = null, curr = start;
        int sum = 0;
        while(curr.next != null) {
            if(curr.next.val == 0) {
                if(prevZero != null) {
                    prevZero.next.val = sum;
                    prevZero.next.next = curr.next;
                    prevZero = prevZero.next;
                }
                else {
                    prevZero = curr;
                }
                sum = 0;
            }
            else {
                sum += curr.next.val;
            }
            curr = curr.next;
        }
        while(prevZero.next != null && prevZero.next.val == 0) {
            prevZero.next = prevZero.next.next;
        }   
        return start.next;
    }
}