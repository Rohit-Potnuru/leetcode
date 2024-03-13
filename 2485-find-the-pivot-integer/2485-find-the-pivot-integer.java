class Solution {
    public int pivotInteger(int n) {
        int sum = n * (n + 1)/2;
        int currSum = 0;
        for(int i = 1; i <= n; i++) {
            if(sum == 2 * currSum + i) {
                return i;
            }
            currSum += i;
        }
        return - 1;
    }
}