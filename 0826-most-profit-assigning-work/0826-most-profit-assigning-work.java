class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxWork = 0;
        for(int work: worker) {
            maxWork = Math.max(maxWork, work);
        }

        int[] jobs = new int[maxWork + 1];
        for(int i = 0; i < profit.length; i++) {
            if(difficulty[i] <= maxWork) {
                jobs[difficulty[i]] = Math.max(jobs[difficulty[i]], profit[i]);
            }
        }

        for(int i = 1; i <= maxWork; i++) {
            jobs[i] = Math.max(jobs[i], jobs[i - 1]);
        }
        
        int netProfit = 0;
        for(int work: worker) {
            netProfit += jobs[work];
        }
        return netProfit;
    }
}