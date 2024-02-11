public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // add empty set
        result.add(new ArrayList<Integer>());
        if (S != null || S.length != 0) {
            Arrays.sort(S);
            subsetRecursive(S, result);
            /*
            for (int i = 0; i < S.length; i++) {
              int setSize = result.size();
              for (int j = 0; j < setSize; j++) {
                ArrayList<Integer> newSubset = new ArrayList<Integer>(result.get(j));
                newSubset.add(S[i]);
                result.add(newSubset);
              }
            }
            */
        }
        return result;
    }
    
    void subsetRecursive(int[] num, ArrayList<ArrayList<Integer>> result) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        subsetRe(num, 0, stack ,result);
    }
    
    void subsetRe(int[] num, int start, Deque<Integer> stack, ArrayList<ArrayList<Integer>> result) {
        if (start == num.length)
           return;
        for (int i = start; i < num.length; i++) {
            stack.offerLast(num[i]);
            ArrayList<Integer> subset = new ArrayList<Integer>();
            subset.addAll(stack);
            result.add(subset);
            subsetRe(num, start + 1, stack, result);
            stack.pollLast();
        }
    }
}