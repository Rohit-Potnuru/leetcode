class Solution {
    public int numSquares(int n) {
        int[] sum = new int[n + 1];
        int maxPow = 0;
        for(int i = 1; i <= n; i++) {
            if((maxPow + 1) * (maxPow + 1) == i) {
                sum[i] = 1;
                maxPow++;
            }
            else {
                int minSum = Integer.MAX_VALUE;
                for(int j = 1; j <= maxPow; j++) {
                    minSum = Math.min(minSum, sum[i - j * j]);
                }
                sum[i] = minSum + 1;
            }
        }
        return sum[n];
    }
}

/*
1     4         9
1 2 3 4 5 6 7 8 9 10 11 12 13
1 2 3 1 2 3 4 2 1 2   3  3
1. 4  9
*/