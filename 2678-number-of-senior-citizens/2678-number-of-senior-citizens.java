class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String detail : details) {
            int age = (detail.charAt(10 + 1) - '0') * 10  + detail.charAt(10 + 2) - '0';
            System.out.println(age);
            if(age > 60) {
                count++;
            }
        }
        return count;
    }
}