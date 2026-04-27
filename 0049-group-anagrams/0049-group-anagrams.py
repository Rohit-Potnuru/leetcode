class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagramMap = dict()
        for word in strs:
            count = [0] * 26
            for ch in word:
                count[ord(ch) - ord('a')] += 1
            count = tuple(count)
            if count not in anagramMap:
                anagramMap[count] = []
            anagramMap[count].append(word)
        
        return list(anagramMap.values())

 
#  """
#         ["eat","tea","tan","ate","nat","bat"]

#         eat -> aet
#         tea -> aet
#         tan -> ant

#         hashmap key sortedKey -> []
#         step1: iter to list
#            each element -> sort element
#             if sort element exists in hashmap
#                append element to list
#             else
#               add new key and add the elemnt
#         m
#         o(mlogm x n) o(m x n)
# """