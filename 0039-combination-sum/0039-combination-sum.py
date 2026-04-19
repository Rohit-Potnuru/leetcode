class Solution:
    def genCombinationSum(self, comb: List[int], target: int, pos: int):
        if target == 0:
            self.res.append(comb[:])
            return
        elif target < 0:
            return
        
        for i in range(pos, len(self.candidates)):
            if target >= self.candidates[i]:
                comb.append(self.candidates[i])
                self.genCombinationSum(comb, target - self.candidates[i], i)
                comb.pop()

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        sortedCandidates = sorted(candidates)
        self.res = []
        self.candidates = sortedCandidates
        self.genCombinationSum([], target, 0)
        return self.res