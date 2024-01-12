class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length(), count = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');
        for(int i = 0; i < n/2; i++) {
            if(vowels.contains(s.charAt(i))) {
                count++;
            }
            if(vowels.contains(s.charAt(n/2 + i))) {
                count--;
            }
        }
        return count == 0;
    }
}