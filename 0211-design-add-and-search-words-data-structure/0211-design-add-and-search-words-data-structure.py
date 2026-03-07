class WordDictionary:

    def __init__(self):
        self.children = [None] * 26
        self.end = False
        
    def addWord(self, word: str) -> None:
        curr = self
        for ch in word:
            idx = ord(ch) - ord('a')
            if curr.children[idx] is None:
                curr.children[idx] = WordDictionary()
            curr = curr.children[idx]
        curr.end = True

    def search(self, word: str) -> bool:
        curr = self
        for idx, ch in enumerate(word):
            if ch == ".":
                for child in curr.children:
                    if child and child.search(word[idx + 1:]):
                        return True
                return False
            else:
                idx = ord(ch) - ord('a')
                if curr.children[idx] is None:
                    return False
                curr = curr.children[idx]
        return curr.end
        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)