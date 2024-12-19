class Solution {
    public int maxChunksToSorted(int[] arr) {
        int pos = 0, curr = 0, n = arr.length, count = 0;
        while(curr < n) {
            if(arr[curr] > pos) {
                pos = arr[curr];
            }
            if(curr == pos) {
                count++;
            }
            curr++;
        }
        return count;
    }
}