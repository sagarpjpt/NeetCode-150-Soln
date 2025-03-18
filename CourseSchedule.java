class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        
        for(int[] pre : prerequisites){
            if(map.containsKey(pre[1]))
                map.get(pre[1]).add(pre[0]);
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(pre[0]);
                map.put(pre[1], temp);
            }
        }

        for(int i = 0;i < numCourses;i++){
            if(cS(i, visited, map) == false)
                return false;
        }
        return true;
    }

    private boolean cS(int i, HashSet<Integer> v, HashMap<Integer, List<Integer>> m){
        if(v.contains(i))
            return false;
        if(m.get(i) == null)
            return true;
        v.add(i);
        for(int pre : m.get(i)){
            if(cS(pre,v,m) == false)
                return false;
        }
        v.remove(i);
        m.put(i, null);
        return true;
    }
}
