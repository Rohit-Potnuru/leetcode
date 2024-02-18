class Solution {
    HashMap<Integer, Integer> primeFreq;
    public static boolean isPrime(int num) {
        // Check if number is less than 2, then it's not prime
        if (num < 2) {
            return false;
        }
        // Check from 2 to the square root of num
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // num is divisible by some number other than 1 and itself
            }
        }
        // num is prime
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