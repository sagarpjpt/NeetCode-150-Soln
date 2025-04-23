class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            //open bracket ---> push to stack 
            if(c == '[' || c == '{' || c == '(')
                stack.push(c);
            //closed bracket ---> if match to top then pop
            else{
                if(stack.isEmpty() || map.get(stack.peek()) != c) return false;
                if(map.get(stack.peek()) == c)
                    stack.pop();
            }
        }
        return stack.isEmpty(); //if stack is empty then valid
    }
}
