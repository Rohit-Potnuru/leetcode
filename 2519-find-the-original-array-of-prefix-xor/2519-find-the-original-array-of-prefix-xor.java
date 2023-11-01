class Solution {
    public int[] findArray(int[] pref) {
        int prev = pref[0], temp;
        for(int i = 1; i < pref.length; i++) {
            temp = pref[i];
            pref[i] ^= prev;
            prev = temp;
        }
        return pref;
    }
}