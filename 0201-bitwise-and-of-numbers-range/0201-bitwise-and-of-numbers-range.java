class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left == right) return left;
        int ans = 0, count = 0;
        while(left > 0 || right > 0) {
            if(left%2 == right%2) {
                ans += left%2 << count;
            }
            else {
                ans = 0;
            }
            count++;
            left = left >> 1;
            right = right >> 1;
        }

        return ans;
    }
}
// 110
// 111

// 11011
// 11111