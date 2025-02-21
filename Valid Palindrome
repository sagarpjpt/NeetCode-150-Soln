class Solution {
    public boolean isPalindrome(String s) {
        String res = s.replaceAll("[^a-zA-Z0-9]","");//replaces any char with null char except for number and char
        String res_lower = res.toLowerCase();
        int i = 0,j = res_lower.length()-1;
        while(i<j){
            if(res_lower.charAt(i) != res_lower.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
