class Solution {
    private Float getSlope_n_intercept(int[] p1, int[] p2) {
        Float slope = (float)Integer.MAX_VALUE;
        if(p1[0] != p2[0]) {
            slope = (float)(p1[1] - p2[1])/(float)(p1[0] - p2[0]);
            slope = (Math.abs(slope) == 0) ? 0 : slope;
        }
        return slope;
    }

    public int maxPoints(int[][] points) {
        HashMap<Float, Integer> lineMap = new HashMap<>();
        int n = points.length, maxPoints = 0;
        for(int i = 0; i < n; i++) {
            lineMap = new HashMap<>();
            for(int j = i + 1; j < n; j++) {
                Float slope = getSlope_n_intercept(points[i], points[j]);
                if(!lineMap.containsKey(slope)) {
                    lineMap.put(slope, 0);
                }
                lineMap.put(slope, lineMap.get(slope) + 1);
                maxPoints = Math.max(maxPoints, lineMap.get(slope));
            }
        }
        return maxPoints + 1;
    }
}