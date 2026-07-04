class Solution {
    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    int count=0;
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        for(int row=0;row<n;row++){
            if(grid[0][row]==1&&!vis[0][row]){
                dfs(0,row,grid,vis);
            }
            if(grid[m-1][row]==1&&!vis[m-1][row]){
                
                dfs(m-1,row,grid,vis);
            }
        }
        for(int col=0;col<m;col++){
            if(grid[col][0]==1&&!vis[col][0]){
                dfs(col,0,grid,vis);
            }
            if(grid[col][n-1]==1&&!vis[col][n-1]){
                dfs(col,n-1,grid,vis);
            }
        }
        return count;
    }
    void dfs(int row,int col,int[][] grid,boolean[][] vis){
        int m=grid.length;
        int n=grid[0].length;
        count--;
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if(nr>=0&&nc>=0&&nr<m&&nc<n&&!vis[nr][nc]&&grid[nr][nc]==1){
                
                dfs(nr,nc,grid,vis);
            }
        }
    }
}