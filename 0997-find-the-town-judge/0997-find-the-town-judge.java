class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] trustPersons = new int[n][2];
        for(int[] t: trust) {
            trustPersons[t[0] - 1][0]++;
            trustPersons[t[1] - 1][1]++;
        }
        for(int i = 0; i < n; i++) {
            if(trustPersons[i][1] == n - 1 && trustPersons[i][0] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}