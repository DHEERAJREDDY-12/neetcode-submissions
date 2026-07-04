class Solution {
    int max=0;
    int area;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,area);
                    area=1;
                    dfs(grid,i,j);
                }
                
            }
        }
        max=Math.max(max,area);

        return max;
    }
    void dfs(int[][] grid,int r,int c){
        grid[r][c]=0;
        int m=grid.length;
        int n=grid[0].length;
        int[] dr={0,0,-1,1};
        int[] dc={-1,1,0,0};
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]==1){
                area++;
                dfs(grid,nr,nc);
            }
        }
    }
}
