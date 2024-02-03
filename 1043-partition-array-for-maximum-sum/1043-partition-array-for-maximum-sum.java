class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length, maxVal, temp;
        int[] maxSum = new int[n];
        for(int i = 0; i < n; i++) {
            maxVal = arr[i];
            for(int j = 0; j < k && i - j >= 0; j++) {
                maxVal = Math.max(maxVal, arr[i - j]);
                temp = maxVal * (j + 1);
                if(i - j - 1 >= 0) {
                    temp += maxSum[i - j - 1];
                }
                maxSum[i] = Math.max(maxSum[i], temp);
            }
        }
        return maxSum[n - 1];
    }
}