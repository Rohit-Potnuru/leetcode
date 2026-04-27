class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagramMap = dict()
        for word in strs:
            sortedWord = "".join(sorted(word))
            if sortedWord not in anagramMap:
                anagramMap[sortedWord] = []
            anagramMap[sortedWord].append(word)
        
        result = []
        for sortedWord in anagramMap:
            result.append(anagramMap[sortedWord])
        return result

 
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