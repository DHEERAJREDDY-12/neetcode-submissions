class Solution {
    int[] dr={0,0,-1,1};
    int[] dc={-1,1,0,0};
    public int numIslands(char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    void dfs(int r,int c,char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        grid[r][c]='0';
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]=='1'){
                dfs(nr,nc,grid);
            }
        }
    }

}
