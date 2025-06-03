/*
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
Example 1:
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
*/ 
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Point> pq = new PriorityQueue<>( (a,b) -> a.dist - b.dist);
        boolean[] inMST = new boolean[n]; // to check point in mst or not

        // start from first point Point(index, dist); dist is to reach index
        pq.offer(new Point(0, 0));

        int minCost = 0;
        int pointsConnected = 0;
        
        while(pointsConnected < n){
            Point current = pq.poll();
            if(inMST[current.ind])    continue; //skip point which already in mst
            inMST[current.ind] = true;
            minCost += current.dist;
            pointsConnected++;

            // update priority queue with distance to new point in mst
            for(int i = 0;i < n;i++){
                if(!inMST[i]){
                    int distance = Math.abs(points[current.ind][0] - points[i][0]) + Math.abs(points[current.ind][1] - points[i][1]);
                    pq.offer(new Point(i, distance));
                }
            }
        }
        return minCost;
    }
}

class Point{
    int ind;
    int dist;
    Point(int ind, int dist){
        this.ind = ind;
        this.dist = dist;
    }
}
