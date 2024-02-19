class Solution {
    public boolean isPowerOfTwo(int n) {
        int t = 1;
        for(int i = 0; i < 31; i++) {
            if(t == n) {
                return true;
            }
            t = t << 1;
        }
        return false;
    }
}