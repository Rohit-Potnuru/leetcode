class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        int i = 0, n = num.length();
        while(i < n) {
            if(k != 0 && !dq.isEmpty() && dq.peekLast() > num.charAt(i)) {
                dq.removeLast();
                k--;
            }
            else {
                dq.addLast(num.charAt(i));
                i++;
            }
        }
        while(k > 0) {
            dq.removeLast();
            k--;
        }
        while(!dq.isEmpty() && dq.peekFirst() == '0') {
            dq.removeFirst();
        }
        StringBuilder res = new StringBuilder();
        while(!dq.isEmpty()) {
            res.append(dq.removeFirst());
        }

        if(res.length() == 0) {
            res.append(0);
        }
        return res.toString();
    }
}