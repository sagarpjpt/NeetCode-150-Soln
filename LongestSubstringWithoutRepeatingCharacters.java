class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 || s.length() == 1) return s.length();
        int maxWindSize = 0,currWindSize = 0;
        HashMap<Character, Integer> map = new HashMap<>();//in WC all char distinct hence SC is theta n 
        // not theta 1
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                currWindSize = 0;
                i = map.get(s.charAt(i)) + 1;
                map.clear();
            }
            currWindSize++;
            maxWindSize = (maxWindSize<currWindSize) ? currWindSize : maxWindSize;
            map.put(s.charAt(i),i);
        }
        return maxWindSize;

        /* if(s.length() == 0 || s.length() == 1) return s.length();
        StringBuilder curr_substr = new StringBuilder();
        StringBuilder long_substr = new StringBuilder();
        //instead of storing substring you should store/track len only
        //note : reduce runtime in ms 
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                curr_substr.replace(0,curr_substr.length(),"");
                i = map.get(s.charAt(i)) + 1; //if key contained in map then we will start finding 
                // the substring from the index next to that found char in string s eg: dvdf
                map.clear();
            }
            curr_substr.append(s.charAt(i));
            if(long_substr.length()<curr_substr.length()){
                long_substr.setLength(0);
                long_substr.append(curr_substr);
            }
            map.put(s.charAt(i),i);//key is char and value is the index of that character
        }
        return long_substr.length(); */
    }
}
