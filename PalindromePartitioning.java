/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]
*/ 
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;end--;
        }
        return true;
    }

    private void helper(String s, int prtIndex, List<String> sub){
        if(prtIndex >= s.length()){
            res.add(new ArrayList<>(sub));
            return;
        }

        // explore all possibiltiy
        for(int end = prtIndex; end < s.length();end++){
            if(isPalindrome(s, prtIndex, end)){
                //add in list
                sub.add(s.substring(prtIndex, end + 1));

                // exploring all 
                helper(s, end + 1, sub);

                // backtrack
                sub.remove(sub.size() - 1);
            }
        }
    }
}
