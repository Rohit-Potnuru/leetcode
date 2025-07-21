class Trie:
    def __init__(self):
        self.children = dict()
        self.end = False
        self.delete = False

    def insert(self, path):
        curr = self
        for folder in path:
            if folder not in curr.children:
                curr.children[folder] = Trie()
            curr = curr.children[folder]
        curr.end = True

    def deleteNode(self):
        curr = self
        children = list(curr.children.keys())
        for child in children:
            if curr.children[child].delete:
                del curr.children[child]
            elif not curr.children[child].delete:
                curr.children[child].deleteNode()
    
    def getPath(self):
        curr = self
        paths = []
        for child in curr.children:
            subPaths = curr.children[child].getPath()
            paths.append([child])
            for path in subPaths:
                paths.append([child] + path)
        return paths


class Solution:
    def serializeDFS(self, curr):
        if len(curr.children) == 0:
            return ""
        serialize = []
        for child in sorted(curr.children.keys()):
            serialize.append(f'{child}({self.serializeDFS(curr.children[child])})')
        
        serialized = ''.join(serialize)
        if serialized in self.serializeNodes:
            curr.delete = True
            self.serializeNodes[serialized].delete = True
            print(serialized)
        self.serializeNodes[serialized] = curr
        return serialized

    def deleteDuplicateFolder(self, paths: List[List[str]]) -> List[List[str]]:
        root = Trie()
        for path in paths:
            root.insert(path)
        
        self.serializeNodes = dict()
        self.serializeDFS(root)
        
        children = list(root.children.keys())
        for child in children:
            if root.children[child].delete:
                del root.children[child]
            elif not root.children[child].delete:
                root.children[child].deleteNode()
        return root.getPath()

#      l
#    a     c    x   y
#    b     b    c   b
#   c d    a    b  c  d
#          b   
#         c d

#      l
#    t    
#    a     c    x   y
#    b     b    c   b
#   c d    a    b  c  d
#          b   
#         c d

# c x
# b c
#   b  
'''
c d b a l

c d b a b c

c x
b c
  b
'''