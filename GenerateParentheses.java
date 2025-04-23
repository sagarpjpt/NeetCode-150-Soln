/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/ 
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        help(2*n, "", res);
        return res;
    }

    private void help(int n, String str, List<String> res) {
        if(n == 0){
            if(isValid(str))
                res.add(str);
            return;
        }

        help(n-1, str + "(", res);

        help(n-1, str + ")", res);
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            //open bracket ---> push to stack
            if(c == '(')
                stack.push(c);
            //closed bracket ---> if match to top then pop
            else{
                if(stack.isEmpty() || ')' != c) return false;
                if(')' == c)
                    stack.pop();
            }
        }
        return stack.isEmpty(); //if stack is empty then valid
    }
}
