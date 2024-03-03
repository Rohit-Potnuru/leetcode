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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(0, head);
        ListNode curr = head, temp = head;
        while(n > 0) {
            temp = temp.next;
            n--;
        }

        while(temp.next != null) {
            curr = curr.next;
            temp = temp.next;
        }
        curr.next = curr.next.next;
        return head.next;
    }
}