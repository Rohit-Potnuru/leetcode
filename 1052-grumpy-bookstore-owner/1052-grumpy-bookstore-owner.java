class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0, n = customers.length;
        int[] prefixSum = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
            prefixSum[i + 1] += prefixSum[i] + customers[i];
        }

        int maxVal = 0;
        for(int i = 0; i <= n - minutes; i++) {
            maxVal = Math.max(maxVal, prefixSum[i + minutes] - prefixSum[i]);
        }
        return sum + maxVal;
    }
}
/*
[1,0,1,2,1,1,7,5]
[0,1,0,1,0,1,0,1]

*/