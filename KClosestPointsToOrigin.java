/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
*/ 
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max heap based on distance using custom comporator
        // a and b denotes a single point[i] = [xi, yi];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];
            return distB - distA; // max-heap largest distance first
        });

        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k)
                pq.poll(); // remove farthest point
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++)
            res[i] = pq.poll();

        return res;
    }
}
