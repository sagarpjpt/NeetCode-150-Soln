class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            // Find the position of #
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            // Extract the length of the string
            int len = Integer.parseInt(str.substring(i, j));
            // Extract the actual string
            String s = str.substring(j + 1, j + 1 + len);
            res.add(s);
            // Move to the next encoded string
            i = j + 1 + len;
        }
        return res;
    }
}
