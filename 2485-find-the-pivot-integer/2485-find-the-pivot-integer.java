class Solution {
    public int pivotInteger(int n) {
        int sum = n * (n + 1)/2;
        for(int i = 1; i <= n; i++) {
            int sumi = i * (i - 1)/2;
            if(sum == 2 * sumi + i) {
                return i;
            }
        }
        return - 1;
    }
}