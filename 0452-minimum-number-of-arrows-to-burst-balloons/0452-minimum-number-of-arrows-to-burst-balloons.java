class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int n = points.length, i = -1;
        int[] prevPoint = points[0];
        for(int[] point: points) {
            if(i >= 0 && point[0] <= prevPoint[1]) {
                prevPoint[0] = Math.max(point[0], prevPoint[0]);
                prevPoint[1] = Math.min(point[1], prevPoint[1]);
            }
            else {
                prevPoint = point;
                i++;
            }
        }
        return i + 1;
    }
}