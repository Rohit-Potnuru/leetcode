class Solution {
    public boolean isPowerOfFour(int n) {
        int start = 0, end = 16;
        while(start <= end) {
            int mid = (end - start)/2 + start;
            if(Math.pow(4, mid) == n)
                return true;
            else if(Math.pow(4, mid) < n)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}