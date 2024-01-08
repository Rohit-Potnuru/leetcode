class Solution {
public:
    int singleNumber(int A[], int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                t += (A[j]>>i & 1)%3;
            }
            res += (t%3)<<i;
        }
        return res;
    }
};