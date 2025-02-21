class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, startIndx = -1;
        int required = t.length(); // Number of characters that need to be matched
        while(right < s.length()) {
            char rightChar = s.charAt(right);
            if(map.containsKey(rightChar)) {
                if(map.get(rightChar) > 0) {
                    required--;
                }
                map.put(rightChar, map.get(rightChar) - 1);
            }
            while(required == 0){ // Valid window found
                // Update the minimum window
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    startIndx = left;
                }
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar) + 1);
                    if(map.get(leftChar) > 0){
                        required++;
                    }
                }
                left++; // Shrink the window
            }

            right++; // Expand the window
        }

        return (startIndx == -1) ? "" : s.substring(startIndx,startIndx + minLen);
    }
}
