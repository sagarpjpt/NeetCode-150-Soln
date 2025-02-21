class Solution {
    public int characterReplacement(String s, int k) {
        //boundary values
        if(s.length() == 1 || s.length() == 0) return s.length();
        if(s.length() == k) return k;
        //core logic
        int left = 0, right = 0;
        int wnd_size = 0,max_freq = 0;;
        HashMap<Character,Integer> map = new HashMap<>();
        for(right = 0;right<s.length();right++){
            //find window size
            wnd_size = right - left + 1;
            //add char to hashmap
            if(map.containsKey(s.charAt(right))) map.put(s.charAt(right),map.get(s.charAt(right))+1 );
            else map.put(s.charAt(right),1);
            // character need to be changed in wnd = wnd size - maxFreq of char in map 
            if(wnd_size - Collections.max(map.values()) > k) //wnd size should be dec when char need to change > k
            {
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
                wnd_size = right - left + 1;
            }
        }
        return wnd_size;
    }
} 
