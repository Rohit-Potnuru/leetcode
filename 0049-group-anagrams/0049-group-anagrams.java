class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        String temp;

        for(String s: strs) {
            char[] s_c = s.toCharArray();
            Arrays.sort(s_c);
            temp = new String(s_c);
            if(!map.containsKey(temp)) {
                map.put(temp, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(temp)).add(s);
        }
        return res;
    }
}