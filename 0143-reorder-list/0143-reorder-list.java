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
        Stack<ListNode> st = new Stack<>();
        ListNode slowCurr = head, temp, next;
        ListNode fastCurr = head.next;
        while(fastCurr != null && fastCurr.next != null) {
            fastCurr = fastCurr.next.next;
            slowCurr = slowCurr.next;
        }

        while(slowCurr != null) {
            st.push(slowCurr);
            slowCurr = slowCurr.next;
        }
        
        slowCurr = head;
        while(!st.isEmpty()) {
            temp = st.pop();
            if(temp == slowCurr) {
                break;
            }
            next = slowCurr.next;
            slowCurr.next = temp;
            temp.next = next;
            slowCurr = next;
        }
        slowCurr.next = null;
    }
}