class Solution {
    public int[][] findFarmland(int[][] land) {
        int rows = land.length, cols = land[0].length;
        ArrayList<int[]> ans = new ArrayList<>();
        int count = 1, temp;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(land[i][j] == 1) {
                    if((i > 0 && land[i - 1][j] < 0) || (j > 0 && land[i][j - 1] < 0)) {
                        temp = (i > 0 && land[i - 1][j] < 0) ? -land[i - 1][j]: -land[i][j - 1];
                        ans.get(temp - 1)[2] = i;
                        ans.get(temp - 1)[3] = j;
                        land[i][j] = -temp;
                    }
                    else {
                        land[i][j] = -count;
                        count++;
                        ans.add(new int[]{i, j, i, j});
                    }
                }
            }
        }
        return ans.toArray(new int[ans.size()][4]);
    }
}