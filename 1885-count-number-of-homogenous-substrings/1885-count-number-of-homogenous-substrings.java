class Solution {
    public int countHomogenous(String s) {
        long count = 0;
        int prev = 0;
        int n = s.length();
        long Q = 1000000007;
        for(int i = 1; i < n; i++) {
            if(s.charAt(prev) != s.charAt(i)) {
                count = (count + ((long)(i - prev) * (i - prev + 1))/2) % Q;
                prev = i;
            }
        }
        count = (count + ((long)(n - prev) * (n - prev + 1))/2) % Q;
        return (int)count;
    }
}