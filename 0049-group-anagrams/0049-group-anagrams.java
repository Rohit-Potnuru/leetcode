class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        String temp;

        for(String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            temp = new String(charArray);
            if(!map.containsKey(temp)) {
                map.put(temp, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(temp)).add(s);
        }
        return res;
    }
}