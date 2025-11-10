/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
*/ 

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Store last index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int end = 0;  // farthest point of current partition
        int size = 0; // size of current partition

        // Traverse and form partitions
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i))); // extend partition boundary
            size++; // increase current partition size

            // When current index reaches partition end, close partition
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
