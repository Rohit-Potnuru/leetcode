# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        res = ListNode()
        headRes = res
        c, vsum, nl1, nl2 = 0, 0, 0, 0
        while l1 != None or l2 != None :
            nl1, nl2 = 0, 0
            if l1 != None:
                nl1, l1 = l1.val, l1.next

            if l2 != None:
                nl2, l2 = l2.val, l2.next

            vsum = (nl1 + nl2 + c) % 10
            c = (nl1 + nl2 + c) / 10

            res.next = ListNode(vsum)
            res = res.next

        if c > 0:
            res.next = ListNode(c)
        return headRes.next
        