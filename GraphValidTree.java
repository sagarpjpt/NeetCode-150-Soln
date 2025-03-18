class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // Construct the adjacency matrix
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        // If the graph is both connected and acyclic, it's a tree
        return isConnected(graph) && !containsCycle(graph);
    }

    private boolean containsCycle(int[][] graph) {
        boolean[] visited = new boolean[graph.length];

        // Since it's an undirected graph, check for cycles from any node
        return hasCycle(graph, visited, 0, -1);
    }

    private boolean hasCycle(int[][] graph, boolean[] visited, int node, int parent) {
        visited[node] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1) { // If there's an edge
                if (!visited[i]) {
                    if (hasCycle(graph, visited, i, node)) return true;
                } else if (i != parent) {
                    return true; // If visited and not parent, cycle detected
                }
            }
        }
        return false;
    }

    private boolean isConnected(int[][] graph) {
        boolean[] visited = new boolean[graph.length];

        // Start DFS from node 0
        dfs(graph, visited, 0);

        // Check if all nodes are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int[][] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }
}
