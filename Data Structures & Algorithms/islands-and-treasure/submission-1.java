class Solution {
    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    public void islandsAndTreasure(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    bfs(0,i,j,grid);
                }
            }
        }
    }
    void bfs(int dis,int r,int c,int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]!=-1&&(dis+1)<grid[nr][nc]){
                grid[nr][nc]=dis+1;
                bfs(grid[nr][nc],nr,nc,grid);
            }
        }
    }

}
