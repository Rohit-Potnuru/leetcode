class Solution {
    public int[] findFactors(int len) {
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 1; i < len; i++) {
            if(len % i == 0) {
                factors.add(i);
            }
        }
        return factors.stream().mapToInt(i -> i).toArray();
    }
    public boolean checkAnagram(String t, HashMap<Character, Integer> map) {
        for(char ch: t.toCharArray()) {
            if(!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }
    public int minAnagramLength(String s) {
        int n = s.length();
        int[] factors = findFactors(n);
        for(int factor : factors) {
            HashMap<Character, Integer> freqMap = new HashMap<>();
            for(int i = 0; i < factor; i++) {
                char ch = s.charAt(i);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }

            boolean flag = true;
            for(int l = 1; l < n/factor; l++) {
                flag = flag && checkAnagram(s.substring(l*factor, (l + 1) * factor), new HashMap<>(freqMap));
            }
            if(flag) return factor;
        }
       return n;
    }
}