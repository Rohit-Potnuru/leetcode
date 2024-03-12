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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode start = new ListNode(0, head);
        HashMap<Integer, ListNode> sumMap = new HashMap<>();
        int sum = 0;
        for(ListNode i = start; i != null; i = i.next) {
            sum += i.val;
            sumMap.put(sum, i);
        }

        sum = 0;
        for(ListNode i = start; i != null; i = i.next) {
            sum += i.val;
            i.next = sumMap.get(sum).next;
        }
        
        return start.next;
    }
}