class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0)
            return res;
        int rows = heights.length, cols = heights[0].length;
        
        boolean pacific[][] = new boolean[rows][cols];
        boolean atlantic[][] = new boolean[rows][cols];

        //recursively traverse from vertices which are adjacent to ocean 
        for(int i = 0;i < cols;i++){
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, rows-1, i, Integer.MIN_VALUE, atlantic);
        }

        for(int i = 0;i < rows;i++){
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, cols-1, Integer.MIN_VALUE, atlantic);
        }

        //copy intersection of pacific and atlantic in result list
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(i);
                    subList.add(j);
                    res.add(subList);
                }
                    
            }
        }
        return res;
    }

    public void dfs(int m[][], int i, int j, int prev, boolean ocean[][]){
        if(i < 0 || j < 0 || i >= m.length || j >= m[0].length) return;
        //check if current land is lower in height than prev land if yes then return
        if(m[i][j] < prev || ocean[i][j]) return;
        //now if current land is heigher than prev so
        //1st set current land co ordinates true
        ocean[i][j] = true;
        //2nd from that land go to all adjacent to find higher land
        dfs(m, i+1, j, m[i][j], ocean);
        dfs(m, i-1, j, m[i][j], ocean);
        dfs(m, i, j+1, m[i][j], ocean);
        dfs(m, i, j-1, m[i][j], ocean);
    }
}
