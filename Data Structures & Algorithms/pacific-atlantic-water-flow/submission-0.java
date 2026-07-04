class Solution {
    int[] dr={0,0,-1,1};
    int[] dc={-1,1,0,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];
        for(int c=0;c<cols;c++){
            dfs(0,c,heights,pacific);
        }
        for(int r=0;r<rows;r++){
            dfs(r,0,heights,pacific);
        }
        for(int c=0;c<cols;c++){
            dfs(rows-1,c,heights,atlantic);
        }
        for(int r=0;r<rows;r++){
            dfs(r,cols-1,heights,atlantic);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pacific[r][c]&&atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }
    public void dfs(int r,int c,int[][] heights,boolean[][] vis){
        vis[r][c]=true;
        int rows = heights.length;
        int cols = heights[0].length;

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 &&
                nr < rows && nc < cols &&
                !vis[nr][nc] &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(nr,nc,heights,vis);
            }
        }
    }

}
