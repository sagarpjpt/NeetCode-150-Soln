/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
The following rules define a valid string:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
*/ 

// ========GREEDY===========
class Solution {
  public boolean checkValidString(String s) {

        int leftMin = 0, leftMax = 0;

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                leftMin += 1;
                leftMax += 1;
            }
            else if(c == ')'){
                leftMin -= 1;
                leftMax -= 1;
            } else {
                leftMin -= 1;
                leftMax += 1;
            }
            if(leftMax < 0) return false;
            if(leftMin < 0) leftMin = 0;
        }

        return leftMin == 0;
    }
}

// =========DICISION TREE===========
/*
public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        return dfs(0, s, stack);
    }

    private boolean dfs(int i, String s, Stack<Character> stack) {
        // base conditions
        if (stack.isEmpty() && i == s.length()) return true;
        if (i == s.length()) return false;

        char c = s.charAt(i);
        boolean a = false, b = false, cCase = false;

        if (c == '(') {
            stack.push(c);
            boolean res = dfs(i + 1, s, stack);
            stack.pop(); // backtrack
            return res;
        } else if (c == ')') {
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                boolean res = dfs(i + 1, s, stack);
                stack.push('('); // backtrack
                return res;
            } else {
                return false;
            }
        } else {
            // wildcard case '*'
            // replace '*' with ')'
            String modified = s.substring(0, i) + ')' + s.substring(i + 1);
            a = dfs(i, modified, (Stack<Character>) stack.clone());

            // replace '*' with '('
            modified = s.substring(0, i) + '(' + s.substring(i + 1);
            b = dfs(i, modified, (Stack<Character>) stack.clone());

            // remove '*'
            modified = s.substring(0, i) + s.substring(i + 1);
            cCase = dfs(i, modified, (Stack<Character>) stack.clone());
        }

        return a || b || cCase;
    }
*/ 
