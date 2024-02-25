class Solution {
    private int find(int idx, int[] union) {
        while(union[idx] >= 0) {
            idx = union[idx];
        }
        return idx;
    }

    // Method to compute the GCD of two numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length, count = 0, max = Integer.MIN_VALUE;
        if(n == 1) return true;
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        int[] union = new int[n];
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if(!hashmap.containsKey(nums[i])) {
                if(nums[i] == 1) return false;
                hashmap.put(nums[i], count);
                union[count] = -1;
                count++;
            }
        }

        boolean[] num_sys = new boolean[max + 1];
        for(int i = 2; i <= max; i++) {
            if(!num_sys[i]) {
                int previ = -1;
                for(int j = i; j <= max; j += i) {
                    num_sys[j] = true;
                    if(hashmap.containsKey(j)) {
                        int rj = find(hashmap.get(j), union);
                        if(previ == -1) {
                            previ = rj;
                        }
                        else if(previ != rj){
                            count--;
                            if(union[previ] > union[rj]) {
                                previ += rj;
                                rj = previ - rj;
                                previ -= rj;
                            }
                            union[previ] += union[rj];
                            union[rj] = previ;
                        }
                    }
                }
            }
        }

        return count == 1;
    }
}
