class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = deck.length;
        for(int i = 0; i < n; i++) {
            dq.add(i);
        }
        int[] res = new int[n];
        Arrays.sort(deck);
        for(int d: deck) {
            res[dq.poll()] = d;
            if(!dq.isEmpty())
            dq.addLast(dq.poll());
        }
        return res;
    }
}