class Solution {
    public int integerBreak(int n) {
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int max = 0;
            for(int j = 1; j <= i/2; j++) {
                max = Math.max(max, arr[j] * arr[i - j]);
                max = Math.max(max,      j * arr[i - j]);
                max = Math.max(max, arr[j] * (i - j));
                max = Math.max(max,      j * (i - j));
            }
            arr[i] = max;
        }
        return arr[n];
    }
}