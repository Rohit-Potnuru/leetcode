class Solution {
    private Float[] getSlope_n_intercept(int[] p1, int[] p2) {
        Float slope = (float)Integer.MAX_VALUE, intercept;
        if(p1[0] != p2[0]) {
            slope = (float)(p1[1] - p2[1])/(float)(p1[0] - p2[0]);
            slope = (Math.abs(slope) == 0) ? 0 : slope;
        }

        intercept = (float)(p1[1]) - slope * ((float)p1[0]);
        return new Float[]{slope, intercept};
    }

    public int maxPoints(int[][] points) {
        HashMap<Float, HashMap<Float, int[]>> lineMap = new HashMap<>();
        int n = points.length, maxPoints = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                Float[] si = getSlope_n_intercept(points[i], points[j]);
                Float slope = si[0], intercept = si[1];
                if(!lineMap.containsKey(slope)) {
                    lineMap.put(slope, new HashMap<>());
                }
                if(!lineMap.get(slope).containsKey(intercept)) {
                    lineMap.get(slope).put(intercept, new int[]{i, 0});
                }
                System.out.println(slope + " " + intercept);
                if(lineMap.get(slope).get(intercept)[0] == i) {
                    int[] temp = lineMap.get(slope).get(intercept);
                    temp[1]++;
                    lineMap.get(slope).put(intercept, temp);
                    maxPoints = Math.max(maxPoints, temp[1]);
                }
            }
        }
        return maxPoints + 1;
    }
}