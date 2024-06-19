class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x: hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(int x: hand) {
            if(map.get(x) > 0) {
                int temp = map.get(x);
                for(int i = 0; i < groupSize; i++) {
                    if(map.get(x + i) < temp) {
                        return false;
                    }
                    map.put(x + i, map.get(x + i) - temp);
                }
            }
        }
        return true;
    }
}