# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root: return "null"
        queue = deque([root])
        serialize = []
        while len(queue) > 0:
            node = queue.popleft() 
            if not node:
                serialize.append("null")
            else:
                serialize.append(str(node.val))
                queue.append(node.left)
                queue.append(node.right)
        print(serialize)
        return ",".join(serialize)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "null": return None
        nodes = data.split(",")
        curr = TreeNode(nodes[0])
        queue = [curr]
        i, n = 1, len(nodes)
        while(i < n):
            node = queue.pop(0)
            if(nodes[i] != "null"):
                node.left = TreeNode(nodes[i])
                queue.append(node.left)
            i += 1
            if(i < n and nodes[i] != "null"):
                node.right = TreeNode(nodes[i])
                queue.append(node.right)
            i += 1
        return curr
        

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
