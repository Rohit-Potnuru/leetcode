class Solution {
    HashMap<Integer, Integer> primeFreq;
    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
 
        if (n == 2 || n == 3)
            return true;
 
        if (n % 2 == 0 || n % 3 == 0)
            return false;
 
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
 
        return true;
    }
    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int maxFreq = 0;
        int maxValue = -1;
        primeFreq = new HashMap<>();
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) continue;
                for(int x = 0; x < m; x++) {
                    for(int y = 0; y < n; y++) {
                        int tx = x, ty = y;
                        int num = mat[x][y];
                        while(0 <= tx + i && tx + i < m && 0 <= ty + j && ty + j < n) { 
                            num = num * 10 + mat[tx + i][ty + j];
                            if(primeFreq.containsKey(num) || isPrime(num)) {
                                int value = primeFreq.getOrDefault(num, 0) + 1;
                                primeFreq.put(num, value);

                                if(maxFreq == value && maxValue < num) {
                                    maxValue = num;
                                }
                                if(maxFreq < value) {
                                    maxFreq = value;
                                    maxValue = num;
                                }
                            }
                            tx = tx + i;
                            ty = ty + j;
                        }
                    }
                }
            }
        }

        return maxValue;
    }
}