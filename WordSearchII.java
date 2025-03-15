class Solution {
    private TrieNode root;
    private int rows, cols;
    private Set<String> result;
    private char[][] board;
    
    public Solution(){
        root = new TrieNode();
    } 
    
    public List<String> findWords(char[][] board, String[] words){
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        result = new HashSet<>();
        
        //build Trie
        for(String word : words)
            addWord(word);
        
        //backtracking search
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++)
                backtrack(i, j, root, "");
        }
        
        return new ArrayList<>(result);
    }

    private void backtrack(int r, int c, TrieNode node, String word){
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '#' || !node.child.containsKey(board[r][c]))
            return;
        
        char ch = board[r][c];
        node = node.child.get(ch);
        word += ch;
        
        if (node.isEnd)
            result.add(word);
        
        //mark the cell as visited
        board[r][c] = '#';
        
        //explore all possible directions
        backtrack(r + 1, c, node, word);
        backtrack(r - 1, c, node, word);
        backtrack(r, c + 1, node, word);
        backtrack(r, c - 1, node, word);
        
        //unmark the cell (backtrack)
        board[r][c] = ch;
    }

    private void addWord(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node.child.putIfAbsent(c, new TrieNode());
            node = node.child.get(c);
        }
        node.isEnd = true;
    }

    class TrieNode{
        Map<Character, TrieNode> child;
        boolean isEnd;

        TrieNode(){
            child = new HashMap<>();
            isEnd = false;
        }
    }
}
