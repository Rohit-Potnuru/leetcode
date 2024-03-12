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
        ListNode curr = start;
        HashMap<Integer, ListNode> sumMap = new HashMap<>();
        int sum = 0;
        while(curr != null) {
            sum += curr.val;
            if(sumMap.containsKey(sum)) {
                ListNode temp = sumMap.get(sum).next;
                while(temp != curr) {
                    sum += temp.val;
                    temp = temp.next;
                    sumMap.remove(sum);
                }
                sum += curr.val;
                sumMap.get(sum).next = curr.next;
            }
            else {
                sumMap.put(sum, curr);
            }
            curr = curr.next;
        }
        return start.next;
    }
}