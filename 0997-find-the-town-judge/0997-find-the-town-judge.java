class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustPersons = new int[n + 1];
        for(int[] t: trust) {
            trustPersons[t[0]]--;
            trustPersons[t[1]]++;
        }
        for(int i = 1; i <= n; i++) {
            if(trustPersons[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}