class Solution {
    String numStr;
    int targetVal;
    List<String> ans;

    private void addOperators(String opStr, int pos, long eval, long multiplyVal) {
        if(pos == numStr.length()) {
            if(eval == targetVal) {
                ans.add(opStr);
            }
            return;
        }
    
        long num = 0;
        for(int i = pos; i < numStr.length(); i++) {
            if(i != pos && numStr.charAt(pos) == '0') break;
            num = num * 10 + (numStr.charAt(i) - '0');
            if(pos == 0) {
                addOperators("" + num, i + 1, num, num);
            }
            else {
                addOperators(opStr + "+" + num, i + 1, eval + num, num);
                addOperators(opStr + "-" + num, i + 1, eval - num, -num);
                addOperators(opStr + "*" + num, i + 1, eval - multiplyVal + multiplyVal * num, multiplyVal * num);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        numStr = num;
        targetVal = target;
        ans = new ArrayList<>();

        long val = 0;
        addOperators("", 0, val, val);
        return ans;
    }
}

/*
123
1
*/