class Trie(object):

    def __init__(self):
        self.isEnd = False
        self.children = dict() #[None] * 26

    def insert(self, word):
        """
        :type word: str
        :rtype: None
        
        don
        root
         d
         o
         n
        """
        curr = self
        for ch in word:
            if ch not in curr.children:
                curr.children[ch] = Trie()
            curr = curr.children[ch]
            
            # i = ord(ch) - ord('a')
            # if(self.children[i] == None) :
            #     self.children[i] = Trie()
        curr.isEnd = True

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        don
        """
        curr = self
        for ch in word:
            if ch not in curr.children:
                return False
            curr = curr.children[ch]
        return curr.isEnd

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        do
        """
        curr = self
        for ch in prefix:
            if ch not in curr.children:
                return False
            curr = curr.children[ch]
        return True
        
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)