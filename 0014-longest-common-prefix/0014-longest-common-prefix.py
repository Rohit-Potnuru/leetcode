class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        ["flower","flow","flight"] -> "fl"
        ["flower","flow","flight", "flig] -> 
        """
        trie = self.Trie()

        for word in strs:
            trie.insert(word)
        prefix_len = trie.search(strs[0], len(strs))
        print(prefix_len)
        if prefix_len == 0:
            return ""
        return strs[0][:prefix_len]
        
    class Trie(object):
        def __init__(self):
            self.count = 0
            self.children = [None] * 26
        
        def insert(self, word):
            current = self
            current.count += 1
            for ch in word:
                norm = ord(ch) - ord("a")
                if current.children[norm] is None:
                    current.children[norm] = Solution.Trie()
                current = current.children[norm]
                current.count += 1


        def search(self, word, length):
            current = self
            count = 0
            for ch in word:
                norm = ord(ch) - ord("a")
                if current.children[norm] is None or current.children[norm].count != length:
                    return count
                current = current.children[norm]
                count += 1
            return count


            