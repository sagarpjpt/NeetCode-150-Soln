/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
*/ 

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
    
        // when endword not in our list
        if(!set.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        if(set.contains(beginWord))
            set.remove(beginWord);

        int level = 0;
        while(!q.isEmpty()){
            int curr_level_size = q.size();
            for(int i = 0;i < curr_level_size;i++) //level wise traversal
            {
                String node = q.poll();

                if(node.equals(endWord))
                    return level+1;
                
                // creating adjacency list of current node
                List<String> neighbours = getNeighbours(node, set);

                // visiting each neigbour of curr node
                for(String word : neighbours){
                    if(set.contains(word)){
                        q.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> getNeighbours(String word, HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();

        for(int i = 0;i < word.length();i++){
            String prefix = word.substring(0,i);
            String suffix = word.substring(i+1, word.length());
            for(char ch = 'a';ch <= 'z';ch++)
            {
                if(ch == word.charAt(i))
                    continue;
                
                // newword ----> prefix + char + suffix
                // String newWord = word.substring(0,i) + ch + word.substring(i+1, word.length());
                String newWord = prefix + ch + suffix;

                if(set.contains(newWord))
                    neighbours.add(newWord);
            }
        }

        return neighbours;
    }
}
