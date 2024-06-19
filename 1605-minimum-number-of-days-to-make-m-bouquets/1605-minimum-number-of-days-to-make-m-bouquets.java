class Solution {
    private int calculate_bouquet(int[] bloomDay, int k, int val) {
        int count = 0;
        int n_bouquets = 0;
        for(int end: bloomDay) {
            if(end <= val) {
                count++;
            }
            else {
                n_bouquets += count/k;
                count = 0;
            }
        }
        n_bouquets += count/k;
        return n_bouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n) {
            return -1;
        }
        int start = 0, end = 1000_000_001, maxEnd = 0, n_bouquets;
        for (int day : bloomDay) {
            maxEnd = Math.max(maxEnd, day);
        }
        end = ++maxEnd;
        while(start < end) {
            int mid = start + (end - start)/2;
            n_bouquets = calculate_bouquet(bloomDay, k, mid);
            if(m <= n_bouquets) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start == maxEnd ? -1 : start;
    }
}