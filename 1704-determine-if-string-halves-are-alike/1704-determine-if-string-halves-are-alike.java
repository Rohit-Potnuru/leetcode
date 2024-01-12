class Solution {
    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch); 
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public boolean halvesAreAlike(String s) {
        int n = s.length(), count = 0;
        for(int i = 0; i < n/2; i++) {
            if(isVowel(s.charAt(i))) {
                count++;
            }
            if(isVowel(s.charAt(n/2 + i))) {
                count--;
            }
        }
        return count == 0;
    }
}