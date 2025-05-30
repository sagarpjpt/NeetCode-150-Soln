/*
In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
Example 1:
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
*/ 
class Solution {
    int totalNodes;
    public int[] findRedundantConnection(int[][] edges) {
        totalNodes = edges.length;
        int res[] = new int[2];
        DSU dsu = new DSU(totalNodes);
        for(int[] edge : edges){
            if(!dsu.unionByRank(edge[0]-1, edge[1]-1))
                res = edge;
        }
        return res;
    }
}

//DisJoint Set ---> better approach to find number of components or two nodes in same or diff componets ?... etc
class DSU{

    int parent[];
    int rank[];
    int components;

    DSU(int nodes){
        // 0 based indexing ---> nodes = 5 --> 0 to 4
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.components = nodes;
        
        for(int i = 0; i <nodes;i++){
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }

    public int findRootParent(int node) {
        if(node == parent[node])
            return node;
        
        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

    public boolean unionByRank(int node1, int node2){
        // find root parent
        int rootParent1= findRootParent(node1);
        int rootParent2= findRootParent(node2);

        if(rootParent1 == rootParent2)
            return false;

        components--;

        // union of components
        if(rank[rootParent1] < rank[rootParent2]){
            parent[rootParent1] = rootParent2;
            rank[rootParent2] += rank[rootParent1];
        }
        else{
            parent[rootParent2] = rootParent1;
            rank[rootParent1] += rank[rootParent2];
        }
        return true;
    }
}
