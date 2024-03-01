class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] res = s.toCharArray();
        int ind = -1; // will not consider first bit because we will add this to last
        for(int i=0;i<res.length;i++) {
            if(res[i] == '1') {
                if(ind != -1) res[ind++] = '1';
                else ind++;
                res[i] = '0'; // reset current
            }
            if(i == res.length-1) res[i] = '1'; // set last bit
        }
        return new String(res);
    }
}