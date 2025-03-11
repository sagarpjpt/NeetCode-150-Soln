class Trie {
    HashMap<String, Boolean> map;
    public Trie() {
        map = new HashMap<>();
    }
    
    public void insert(String word) {
        if(!map.containsKey(word))
            map.put(word,true);
    }
    
    public boolean search(String word) {
        if(map.containsKey(word)) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        for(String str : map.keySet()){
            if(prefix.length() <= str.length() && prefix.equals(str.substring(0,prefix.length())))
                return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
