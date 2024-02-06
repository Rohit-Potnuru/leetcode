class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        String temp;

        for(String s: strs) {
            int[] count = new int[26];
            for(char ch: s.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i: count) {
                sb.append(i); 
            }
            temp = sb.toString();
            if(!map.containsKey(temp)) {
                map.put(temp, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(temp)).add(s);
        }
        return res;
    }
}