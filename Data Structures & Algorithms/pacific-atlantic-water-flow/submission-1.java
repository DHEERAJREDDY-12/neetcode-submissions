class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        for(int i=0;i<n;i++){
            dfs(heights,0,i,pacific);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pacific);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,n-1,atlantic);
        }
        for(int i=0;i<n;i++){
            dfs(heights,m-1,i,atlantic);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]&&atlantic[i][j]){
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return res;

    }
    void dfs(int[][] heights,int r,int c,boolean[][] vis){
        vis[r][c]=true;
        int m=heights.length;
        int n=heights[0].length;
        int[] dr={0,0,-1,1};
        int[] dc={-1,1,0,0};
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nc>=0&&nr<m&&nc<n&&!vis[nr][nc]&&heights[nr][nc]>=heights[r][c]){
                
                dfs(heights,nr,nc,vis);
            }
        }
    }
}
