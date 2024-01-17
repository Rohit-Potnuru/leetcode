class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        HashSet<Integer> hashset = new HashSet<>();
        int prev = arr[0] - 1, count = 0;
        for(int a: arr) {
            if(prev != a) {
                if(hashset.contains(count)) {
                    return false;
                }
                hashset.add(count);
                count = 0;
            }
            count++;
            prev = a;
        }
        if(hashset.contains(count)) {
            return false;
        }
        return true;
    }
}