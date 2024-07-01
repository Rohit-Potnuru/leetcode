class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int num: arr) {
            if(count == 3) {
                return true;
            }
            if(num % 2 == 1) {
                count++;
            }
            else {
                count = 0;
            }
        }
        return count >= 3;
    }
}