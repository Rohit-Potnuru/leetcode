class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0, val = tickets[k], n = tickets.length;
        for(int i = 0; i < n; i++) {
            if(i <= k) {
                res += Math.min(tickets[i], val);
            }
            else {
                res += Math.min(tickets[i], val - 1);
            }
        }
        return res;
    }
}