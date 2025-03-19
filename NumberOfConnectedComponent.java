class Solution {
    public int countComponents(int n, int[][] edges) {
        //creating adjacency matrix
        int[][] graph = new int[n][n];
        for(int e[] : edges){
            graph[e[0]][e[1]] = 1;
            graph[e[1]][e[0]] = 1;
        }
        //use dfs to find number of components(k)
        int k = 0;
        int visited[] = new int[n];
        for(int i = 0;i < n;i++){
            if(visited[i] == 0)
                k++;
                dfs(graph, visited, i);
        }

        return k;
    }

    private void dfs(int g[][], int v[], int node){
        v[node] = 1;
        for(int i = 0;i < g[node].length;i++){
            if(v[i] == 0 && g[node][i] == 1)
                dfs(g,v,i);
        }
    }
}
