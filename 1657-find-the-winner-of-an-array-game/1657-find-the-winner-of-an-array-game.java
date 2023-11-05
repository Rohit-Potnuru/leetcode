class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int maxValue = arr[0];
        int winner = arr[0];
        int wins = 0;
        for(int i = 1; i < n; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            if(winner < arr[i]) {
                wins = 1;
                winner = arr[i]; 
            }
            else {
                wins++;
            }

            if(wins == k)
                return winner;
        }
        return maxValue;
    }
}