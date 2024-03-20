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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2End = list2;
        while(list2End.next != null) {
            list2End = list2End.next;
        }

        ListNode currA = list1, currB = list1;
        a--;
        while(a != b) {
            currB = currB.next;
            b--;
        }

        while(a > 0) {
            currA = currA.next;
            currB = currB.next;
            a--;
        }
        currA.next = list2;
        list2End.next = currB.next;
        return list1;
    }
}