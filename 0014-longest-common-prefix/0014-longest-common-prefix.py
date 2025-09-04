class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        ["flower","flow","flight"] -> "fl"
        ["flower","flow","flight", "flig] -> 
        """
        self.prefix = strs[0]
        b = self.Trie()
        b.insert(self.prefix)

        for word in strs[1:]:
            current = b
            for ch in range(0, len(word)):
                val = ord(word[ch]) - ord("a")
                if current.children[val] is None :
                    self.prefix = self.prefix[:ch]
                    break
                current = current.children[val]
            if len(self.prefix) >  len(word):
                self.prefix = word
        return self.prefix
    
    class Trie(object):
        def __init__(self):
            self.isEnd = False
            self.children = [None] * 26
        
        def insert(self, word):
            current = self

            for ch in word:
                norm = ord(ch) - ord("a")
                if current.children[norm] is None:
                    current.children[norm] = Solution.Trie()
                current = current.children[norm]
            current.isEnd = True
            