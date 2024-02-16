class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int prev = arr[0], count = 0;
        ArrayList<Integer> freqCount = new ArrayList<>();
        for(int a: arr) {
            if(prev != a) {
                freqCount.add(count);
                prev = a;
                count = 0;
            }
            count++;
            prev = a;
        }
        freqCount.add(count);
        Collections.sort(freqCount);

        count = freqCount.size();
        int j = 0;
        while(j < freqCount.size() && k > 0) {
            k -= freqCount.get(j++);
        }
        if(k != 0) j--;

        return count - j;
    }
}