class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        stack = []
        i = 0
        preorder_nodes = preorder.split(',')
        while i < len(preorder_nodes):
            if preorder_nodes[i] != '#':
                stack.append([preorder_nodes[i], 'l'])
            else:
                if stack and stack[-1][1] == 'r':
                    stack.pop()
                    while stack and stack[-1][1] == 'r':
                        stack.pop()    
                if i + 1 < len(preorder_nodes):
                    if not stack:
                        return False
                    stack[-1][1] = 'r'
            i += 1
        return len(stack) == 0

        