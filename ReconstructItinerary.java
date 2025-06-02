/*
You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
Example 1:
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
*/ 
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // constructing graph
        HashMap<String, List<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            if(!graph.containsKey(src)){
                graph.put(src, new ArrayList<>());
                graph.get(src).add(dest);
            }
            else
                graph.get(src).add(dest);
        }

        // sorting the adj list for lexical sorting 
        for(List<String> destinations : graph.values())
            Collections.sort(destinations);

        List<String> res = new ArrayList<>();

        dfs(graph, "JFK", res);

        return res;
    }

    private void dfs(HashMap<String, List<String>> graph, String airport, List<String> res){
        List<String> dest = graph.get(airport);
        while(dest != null && !dest.isEmpty()){
            String next = dest.remove(0);
            dfs(graph, next, res);
        }
        res.add(0, airport);
    }
}
