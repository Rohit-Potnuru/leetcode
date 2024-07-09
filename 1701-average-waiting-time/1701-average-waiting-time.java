class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double sum = 0.0;
        int serve = 0;
        for(int[] customer: customers) {
            if(customer[0] > serve) {
                serve = customer[0];
            }
            serve += customer[1];
            sum += serve - customer[0];
        }
        return sum/(double)n;
    }
}