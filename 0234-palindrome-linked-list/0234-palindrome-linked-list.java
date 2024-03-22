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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        ListNode fastCurr = head.next;
        stack.push(curr.val);
        while(fastCurr != null && fastCurr.next != null) {
            curr = curr.next;
            fastCurr = fastCurr.next.next;
            stack.push(curr.val);
        }
        curr = curr.next;
        if(fastCurr == null) {
            stack.pop();
        }
        while(curr != null) {
            System.out.println(curr.val);
            if(curr.val != stack.pop()) return false;
            curr = curr.next;
        }
        return true;
    }
}