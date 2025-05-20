/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:
Input: digits = ""
Output: []
Example 3:
Input: digits = "2"
Output: ["a","b","c"]
*/ 
class Solution {
    HashMap<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0) return res;
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper(digits, 0, new StringBuilder(""));
        return res;
    }

    private void helper(String digits, int index, StringBuilder comb){
        if(index == digits.length()){
            res.add(comb.toString());
            return;
        }
        String string = map.get(digits.charAt(index));
        // expanding all combinations
        for(int i = 0; i < string.length();i++){
            comb.append(string.charAt(i));

            // recursive call
            helper(digits, index + 1, comb);

            // backtrack
            comb.deleteCharAt(comb.length() - 1);
        }

    }
}
