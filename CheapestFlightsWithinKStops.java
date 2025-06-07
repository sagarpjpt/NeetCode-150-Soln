/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
*/ 

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n]; // dist is used to read from in current iteration
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // relaxing all edges k+1 times
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dist, n); // temp hold updation in current iteration
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int price = flight[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + price < temp[v]) {
                    temp[v] = dist[u] + price;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

/*

// inefficint way --- gives TLE

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // create adjacency list
        List<int[]>[] adj_list = new ArrayList[n];
        for (int i = 0; i < n; i++) adj_list[i] = new ArrayList<>();
        for (int[] flight : flights) {
            adj_list[flight[0]].add(new int[]{flight[1], flight[2]});  // {dest, price}
        }

        // pq {total_price, current_node, stops_so_far}
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        pq.offer(new Element(src, 0, 0));  // start from src, price=0, stops=0

        while (!pq.isEmpty()) {
            Element ele = pq.poll();

            int curr_node = ele.dest;
            int price_so_far = ele.price;
            int stops_so_far = ele.stops;

            if (curr_node == dst) return price_so_far;

            if (stops_so_far > k) continue;

            for (int[] nei : adj_list[curr_node]) {
                int next_node = nei[0];
                int next_price = nei[1];
                pq.offer(new Element(next_node, price_so_far + next_price, stops_so_far + 1));
            }
        }

        return -1;
    }
}

class Element {
    int dest;
    int price;
    int stops;
    Element(int dest, int price, int stops) {
        this.dest = dest;
        this.price = price;
        this.stops = stops;
    }
}


*/ 
