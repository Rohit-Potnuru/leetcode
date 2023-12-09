class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int pow = 1;
        int level = 0;
        while(label >= pow) {
            pow *= 2;
            level++;
        }
        System.out.println(pow + " " + level+ " " + label);
        int pos = (level%2 == 0) ? (pow - label): (label - pow/2 + 1);
        ArrayList<Integer> res = new ArrayList<>();
        while(level > 0) {
            if(level % 2 == 0) {
                res.add(pow - pos);
            }
            else {
                res.add(pow/2 + pos - 1);
            }
            pos = (pos + 1)/2;
            pow /= 2;
            level--;
        }

        int n = res.size();
        for(int i = 0; i < n/2; i++) {
            int temp = res.get(i);
            res.set(i, res.get(n - i - 1));
            res.set(n - i - 1, temp);
        }
        return res;
    }
}