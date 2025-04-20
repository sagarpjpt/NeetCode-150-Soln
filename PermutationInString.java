/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
*/ 

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        int len = s1.length();

        // Initialize the s1 count
        for (int i = 0; i < len; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        if (matches(s1Count, windowCount)) return true;

        for (int i = len; i < s2.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++;   // include new char
            windowCount[s2.charAt(i - len) - 'a']--;  // exclude old char
            if (matches(s1Count, windowCount)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
