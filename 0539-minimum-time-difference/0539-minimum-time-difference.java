class Solution {
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public int findMinDifference(List<String> timePoints) {
        
        ArrayList<Integer> minutesPoints = timePoints.stream()
            .map(Solution::convertToMinutes)
            .collect(Collectors.toCollection(ArrayList::new));
        
        minutesPoints.sort((a, b) -> {return a - b;});

        int prev = -1440;
        int minTime = Integer.MAX_VALUE;
        for(int point: minutesPoints) {
            minTime = Math.min(minTime, point - prev);
            prev = point;
        }
        minTime = Math.min(minTime, 1440 + minutesPoints.get(0) - prev);
        return minTime;
    }
}