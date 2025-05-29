/*
You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
Return a valid ordering of courses you can take to finish all courses. If there are many valid answers, return any of them. If it's not possible to finish all courses, return an empty array.
Example 1:
Input: numCourses = 3, prerequisites = [[1,0]]
Output: [0,1,2]
Explanation: We must ensure that course 0 is taken before course 1.
*/ 

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> adj_list[] = new ArrayList[numCourses];
        int[] in_degree = new int[numCourses];

        //init adjacency list
        for(int i = 0;i < numCourses;i++){
            adj_list[i] = new ArrayList<>();
        }

        // building graph and in-degree array
        for(int[] pre : prerequisites){
            int course = pre[0];
            int req = pre[1];
            adj_list[req].add(course);
            in_degree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int ind = 0;
        for(int deg : in_degree){
            if(deg == 0)
                q.offer(ind);
            ind++;
        }

        int res[] = new int[numCourses];
        ind = 0;

        // bfs from node having indegree 0
        while(!q.isEmpty()){
            int node = q.poll();
            res[ind++] = node;
            for(int neighbor : adj_list[node]){
                in_degree[neighbor]--;
                if(in_degree[neighbor] == 0)
                    q.offer(neighbor);
            }
        }

        return ind == numCourses ? res : new int[0];

    }
}
