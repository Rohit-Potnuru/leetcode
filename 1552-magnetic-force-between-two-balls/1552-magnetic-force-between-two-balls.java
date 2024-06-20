class Solution {
    private boolean isValidBallPlaces(int x, int m, int[] position) {
        int prevBallPos = position[0];
        m--;
        for(int pos: position) {
            if(pos - prevBallPos >= x && m > 0) {
                prevBallPos = pos;
                m--;
            }
        }
        return m <= 0;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1, end = position[position.length - 1];
        int ans = 0;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(isValidBallPlaces(mid, m, position)) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(start + " " + end);
        return ans;
    }
}