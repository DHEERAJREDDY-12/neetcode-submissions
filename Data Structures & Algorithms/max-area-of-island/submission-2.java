class Solution{
    int[] dr={0,0,-1,1};
    int[] dc={-1,1,0,0};
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(i,j,grid));
                }
            }
        }
        return max;
    }
    int dfs(int r,int c,int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        grid[r][c]=0;
        int area=1;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]==1){
                area+=dfs(nr,nc,grid);
            }
        }
        return area;
    }
}

