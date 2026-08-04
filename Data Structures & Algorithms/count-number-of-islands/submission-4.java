class Solution {
    int[] dr={0,0,-1,1};
    int[] dc={-1,1,0,0};
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count+=1;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int r,int c){
        int m=grid.length;
        int n=grid[0].length;
        
        if(r<0||c<0||r>=m||c>=n||grid[r][c]=='0') return;
        grid[r][c]='0';
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            dfs(grid,nr,nc);
        }

    }
}
