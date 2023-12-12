class Solution {
    public int maxProduct(int[] nums) {
        int maxFirst = 0, maxSecond = 0;
        for(int num: nums) {
            if(maxFirst < num) {
                maxSecond = maxFirst;
                maxFirst = num;
            }
            else if(maxSecond < num) {
                maxSecond = num;
            }
        }
        return (maxFirst - 1) * (maxSecond - 1);
    }
}