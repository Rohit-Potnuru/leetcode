class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int i = 1;
        int prevEnd = points[0][1];
        for(int[] point: points) {
            if(prevEnd < point[0]) {
                prevEnd = point[1];
                i++;
            }
        }
        return i;
    }
}