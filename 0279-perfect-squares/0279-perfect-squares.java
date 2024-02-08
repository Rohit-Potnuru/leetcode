class Solution {
    /*
      Implemented based on this Solution: https://leetcode.com/problems/perfect-squares/solutions/4694905/legendre-s-3-square-lagrange-s-4-square-theorems-0ms-beats-100
    */
    public boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return sqrt == (int)(sqrt);
    }

    public int numSquares(int n) {
        while(n % 4 == 0) {
            n /= 4;
        }

        if(n % 8 == 7) return 4;
        double sqrt = Math.sqrt(n);
        if(sqrt == (int)(sqrt)) return 1;
        for(int i = 1; i <= sqrt; i++) {
            int y = n - i * i;
            if(isSquare(y)) return 2;
        }
        return 3;
    }
}

/*
1     4         9
1 2 3 4 5 6 7 8 9 10 11 12 13
1 2 3 1 2 3 4 2 1 2   3  3
1. 4  9
*/