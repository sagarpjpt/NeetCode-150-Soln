/**                                             prefix tree str for given eg.
    TrieNode(TN) structure                              b
    _______________________________                     m
    |   HashMap     |              |                    d
    |  key | TN(val)|              |                    |
    |      |        |    isEnd     |                   /|\
    |      |        |              |                  / | \
    |_______________|______________|                 /  |  \
                                                    a   a   a
                                                   /    |    \
                                                  d     d     d
                                                 /      |      \
                                       isEnd=true       |    isEnd=true
                                                  isEnd=true
 */

class WordDictionary {

    private TrieNode root;
    
    public WordDictionary() {
       root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node.child.putIfAbsent(c, new TrieNode());
            node = node.child.get(c);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchTree(word, 0, root);
    }

    public boolean searchTree(String word, int index, TrieNode node){
        if(node == null) return false;
        if(index == word.length()) return node.isEnd;

        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode child : node.child.values()){
                if(searchTree(word, index+1, child))
                    return true;
            }
            return false;
        }
        else
            return searchTree(word, index + 1, node.child.get(c)); //note if key not in hashmap it will return null
    }

    //using a prefix tree(trie) for fast search and insert
    class TrieNode {
        Map<Character, TrieNode> child;
        boolean isEnd;

        TrieNode(){
            child = new HashMap<>();
            isEnd = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
