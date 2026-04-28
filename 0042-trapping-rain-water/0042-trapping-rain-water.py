class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        maxL = height[l]
        maxR = height[r]
        total = 0
        while l < r:
            if height[l] < height[r]:
                l += 1
                total += max(0, maxL - height[l])
                maxL = max(maxL, height[l])
            else:
                r -= 1
                total += max(0, maxR - height[r])
                maxR = max(maxR, height[r])
        return total
