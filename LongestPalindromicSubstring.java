/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) return s;
            else return s.substring(0, 1);
        }

        String output = "";

        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindrome
            String temp1 = sub(s, i, i);
            if (temp1.length() > output.length())
                output = temp1;

            // Check for even-length palindrome
            String temp2 = sub(s, i, i + 1);
            if (temp2.length() > output.length())
                output = temp2;
        }
        return output;
    }

    private String sub(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
