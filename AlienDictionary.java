/*
There is a foreign language which uses the latin alphabet, but the order among letters is not "a", "b", "c" ... "z" as in English.

You receive a list of non-empty strings words from the dictionary, where the words are sorted lexicographically based on the rules of this new language.

Derive the order of letters in this language. If the order is invalid, return an empty string. If there are multiple valid order of letters, return any of them.

A string a is lexicographically smaller than a string b if either of the following is true:

The first letter where they differ is smaller in a than in b.
There is no index i such that a[i] != b[i] and a.length < b.length.
Example 1:

Input: ["z","o"]

Output: "zo"
Explanation:
From "z" and "o", we know 'z' < 'o', so return "zo".

Example 2:

Input: ["hrn","hrf","er","enn","rfnn"]

Output: "hernf"
*/

class Solution {
    private Map<Character, List<Character>> graph = new HashMap<>();
    private Set<Character> visited = new HashSet<>();
    private Set<Character> visiting = new HashSet<>();
    private Stack<Character> topoStack = new Stack<>();
    public String foreignDictionary(String[] words) {
        //init graph with all unique char
        for(String word : words){
            for(char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        // adjacent char a--->b when a < b (a is lexicographically smaller than b)
        for(int i = 0; i < words.length -1; i++){
            String word1 = words[i], word2 = words[i+1];
            int minLen = Math.min(word1.length(), word2.length());

            //when word2 is prefix of first --- invalid order
            if(word1.length() > word2.length() && word1.startsWith(word2))
                return "";

            //find first diff char
            for(int j = 0; j < minLen; j++) {
                if(word1.charAt(j) != word2.charAt(j)){
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        //dfs for TS
        for(char c : graph.keySet()) {
            if(!visited.contains(c)){
                if(hasCycle(c))
                    return ""; // cycle detected
            }
        }

        StringBuilder order = new StringBuilder();
        while(!topoStack.isEmpty()) 
            order.append(topoStack.pop());
        return order.toString();
    }

    private boolean hasCycle(char node){
        if(visiting.contains(node)) return true; //cycle detected
        if(visited.contains(node)) return false;

        visiting.add(node);

        for(char neighbor : graph.get(node)) {
            if(hasCycle(neighbor)) return true;
        }
        
        visiting.remove(node);
        visited.add(node);
        topoStack.push(node);
        return false;
    }
}
