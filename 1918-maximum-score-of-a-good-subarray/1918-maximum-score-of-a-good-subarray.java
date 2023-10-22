class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k, right = k;
        int currMin = nums[k];
        int maxScore = nums[k];
        while(left >= 0 || right < n) {
            while(left >= 0 && nums[left] >= currMin)
                left--;
            
            while(right < n && nums[right] >= currMin)
                right++;

            maxScore = Math.max(maxScore, currMin * (right - left - 1));
            if(left < 0 && right >= n) 
                continue;
            if(left < 0)
                currMin = nums[right];
            else if(right >= n)
                currMin = nums[left];
            else {
                if(nums[left] < nums[right]) {
                    currMin = nums[right];
                    left++;
                }
                else {
                    currMin = nums[left];
                    right--;
                }
            }
        }
        return maxScore;
    }
}

/*
k = 3
0,k  k,n

0 1 2 3 4 5 6 7

0-3 min
1-3
2-3
3-3

3-3
3-4
3-5
3-6
3-7


*/