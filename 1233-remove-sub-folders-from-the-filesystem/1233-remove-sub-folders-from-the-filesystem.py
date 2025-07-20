class Trie:
    def __init__(self):
        self.children = dict()
        self.end = False
        self.path = '?'
    
    def insert(self, folder):
        curr = self
        for path in folder.split('/'):
            if path not in curr.children:
                curr.children[path] = Trie()
            curr = curr.children[path]
        curr.end = True
        curr.path = folder
        
class Solution:
    def dfs(self, trie):
        if trie.end == True:
            self.ans.append(trie.path)
            return

        for child in trie.children:
            self.dfs(trie.children[child])
            
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        """
        :type folder: List[str]
        :rtype: List[str]
        """
        self.ans = []
        currTrie = Trie()
        for subFolder in folder:
            currTrie.insert(subFolder)
        self.dfs(currTrie)
        return self.ans
        