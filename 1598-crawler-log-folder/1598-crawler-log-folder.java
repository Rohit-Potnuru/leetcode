class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for(String log: logs) {
            if(log.charAt(0) != '.') {
                count++;
            }
            else if(log.charAt(1) == '.') {
                count--;
                count = Math.max(0, count);
            }
        }
        return count;
    }
}