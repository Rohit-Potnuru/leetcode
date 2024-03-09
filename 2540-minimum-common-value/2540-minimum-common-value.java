class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int s1 = 0, s2 = 0;
        while(s1 < n1 && s2 < n2) {
            if(nums1[s1] < nums2[s2]) {
                s1++;
            }
            else if(nums1[s1] > nums2[s2]) {
                s2++;
            }
            else {
                return nums1[s1];
            }
        }
        return -1;
    }
}