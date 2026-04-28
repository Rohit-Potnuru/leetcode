class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        i = 0
        j = n - 1
        maxArea = 0
        while i < j:
            area = min(height[i], height[j]) * (j - i)
            maxArea = max(maxArea, area)
            if height[i] < height[j]:
                i += 1
            else:
                 j -= 1
        return maxArea