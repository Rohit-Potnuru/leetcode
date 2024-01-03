class Solution {
    public int numberOfBeams(String[] bank) {
        int totalLasers = 0, prev = 0;
        for(int i = 0; i < bank.length; i++) {
            int sum = 0;
            for(int j = 0; j < bank[i].length(); j++) {
                sum += bank[i].charAt(j) - '0';
            }
            if(sum != 0) {
                totalLasers += prev * sum;
                prev = sum;
            }
        }
        return totalLasers;
    }
}