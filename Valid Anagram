class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char s_array[] = s.toCharArray();
        char t_array[] = t.toCharArray();
        Arrays.sort(s_array);
        Arrays.sort(t_array);
        String sorted_s = new String(s_array);
        String sorted_t = new String(t_array);
        if(sorted_s.equalsIgnoreCase(sorted_t)) return true;
        return false;
    }
}
