class Solution {

    public int maxLength(List<String> arr) {
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        int max = 0;
        for(String s: arr) {

            int a = 0, dup = 0;
            for(char ch: s.toCharArray()) {
                dup |= a & 1 << (ch - 'a');
                a |= 1 << (ch - 'a');
            }

            if(dup > 0) continue;

            for(int i = dp.size() - 1; i >= 0; --i) {
                int d = dp.get(i);
                if((d & a) > 0) continue;
                dp.add(d | a);
                max = Math.max(max, Integer.bitCount(d|a));
            }

        }
        return max;
    }
}