class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<String, List<String>> hMap = new HashMap<>();
         for(String s : strs){
            char temp[] = s.toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);
            hMap.putIfAbsent(sortedStr, new ArrayList<>()); //put the key value pair if key is absent
            hMap.get(sortedStr).add(s);
         }
        return new ArrayList<>(hMap.values());
        // List<List<String>> list_out = new ArrayList<>();
        // int flag[] = new int[strs.length];
        // String copyStr[] = strs.clone();
        // for(int i = 0 ;i<strs.length;i++){
        //     char temp[] = strs[i].toCharArray();
        //     Arrays.sort(temp);
        //     copyStr[i] = new String(temp);
        // }
        // for(int i = 0;i < copyStr.length;i++){
        //     if(flag[i] == 1) continue;
        //     List<String> innerStr = new ArrayList<>(Arrays.asList(strs[i]));
        //     for(int j = i+1 ; j<copyStr.length;j++){
        //         if(copyStr[i].length() != copyStr[j].length()) continue;
        //         if(copyStr[i].equalsIgnoreCase(copyStr[j])){
        //             innerStr.add(strs[j]);
        //             flag[j] = 1;
        //         }
        //     }
        //     list_out.add(innerStr);
        // }
        // return list_out;
    }
}
