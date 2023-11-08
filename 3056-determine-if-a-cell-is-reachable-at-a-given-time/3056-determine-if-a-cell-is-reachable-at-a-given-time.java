class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(Math.max(Math.abs(fx - sx), Math.abs(fy - sy)) == 0)
            return t != 1;
        return Math.max(Math.abs(fx - sx), Math.abs(fy - sy)) <= t;
    }
}