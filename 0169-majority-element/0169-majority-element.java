class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, majority = 0;
        for(int num: nums) {
            if(majority != num) {
                if(count == 0) {
                    majority = num;
                    count = 1;
                }
                count--;
            }
            else {
                count++;
            }
        }
        return majority;
    }
}