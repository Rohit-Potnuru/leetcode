class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Expand around i as the center for odd length palindromes
            count += expandAroundCenter(s, i, i);
            // Expand around i and i+1 as the center for even length palindromes
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }

    // Helper method to expand around the center and count palindromes
    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // Found a palindrome, move outward
            count++;
            left--;
            right++;
        }
        return count;
    }
}