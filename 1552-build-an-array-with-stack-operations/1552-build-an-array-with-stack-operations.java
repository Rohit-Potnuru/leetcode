class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> ans = new ArrayList<String>();
        int curr = 1;
        for(int i = 0; i < target.length; i++) {
            for(int j = curr; j < target[i]; j++) {
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
            curr = target[i] + 1;
        }
        return ans;
    }
}