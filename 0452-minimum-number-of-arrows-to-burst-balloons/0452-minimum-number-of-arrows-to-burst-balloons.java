class Solution {
    public int findMinArrowShots(int[][] points) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int n = points.length, i = -1;
        for(int[] point: points) {
            if(i >= 0 && point[0] <= ans.get(i)[1]) {
                ans.get(i)[0] = Math.max(point[0], ans.get(i)[0]);
                ans.get(i)[1] = Math.min(point[1], ans.get(i)[1]);
            }
            else {
                ans.add(point);
                i++;
            }
        }
        return i + 1;
    }
}