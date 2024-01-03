class Solution {
    public int numberOfBeams(String[] bank) {
        int totalLasers = 0, prev = 0;
        for(String b: bank) {
            int sum = 0;
            for(int j = 0; j < b.length(); j++) {
                sum += b.charAt(j) - '0';
            }
            totalLasers += prev * sum;
            if(sum != 0) {
                prev = sum;
            }
        }
        return totalLasers;
    }
}