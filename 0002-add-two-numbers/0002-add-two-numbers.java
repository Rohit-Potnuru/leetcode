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
        ListNode res = new ListNode(), headRes;
        headRes = res;
        int c = 0, sum, nl1 = 0, nl2 = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                nl1 = l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                nl2 = l2.val;
                l2 = l2.next;
            }

            sum = (nl1 + nl2 + c) % 10;
            c = (nl1 + nl2 + c) / 10;

            res.next = new ListNode(sum);
            res = res.next;
            nl1 = 0;
            nl2 = 0;
        }
        if(c > 0) {
            res.next = new ListNode(c);
        }
        return headRes.next;
    }
}