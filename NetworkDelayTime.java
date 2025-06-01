/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
*/ 
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]> adj_list[] = new ArrayList[n];

        // init adj list
        for(int i = 0;i < n;i++)
            adj_list[i] = new ArrayList<>(); 

        // constructing graph ----> considering 0 indexed nodes name 
        // i.e. n = 5 means nodes are 0,1,2,3,4
        for(int[] time : times){
            int u = time[0] - 1;
            int v = time[1] - 1;
            int t = time[2];
            adj_list[u].add(new int[] {v,t});
        }

        int minTimes[] = dijkstra(k-1, n, adj_list);
        int res = Integer.MIN_VALUE;
        for(int time : minTimes)
        {
            if(time == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res, time);
        }
        
        return res;
    }

    private int[] dijkstra(int src, int n, List<int[]>[] adj){
        // custom heap ---> delete the nodes having min Time
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int p1[], int p2[]){
                return p1[1] - p2[1];
            }
        });
        int time[] = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[src] = 0;

        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int pair[] = pq.poll();
            int u = pair[0];
            int d = pair[1];
            if(d > time[u]) continue;
            for(int[] neighbour : adj[u]){
                int v = neighbour[0];
                int w = neighbour[1];
                // relaxing an edge
                if(time[u] + w < time[v])
                {
                    time[v] = time[u] + w;
                    pq.offer(new int[]{v, time[v]});
                }

            }
        }
        return time;
    }
}
