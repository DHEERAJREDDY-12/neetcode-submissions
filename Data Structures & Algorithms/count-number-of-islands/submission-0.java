class Solution {
    int dr[]={-1,1,0,0};
    int dc[]={0,0,-1,1};
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]=='1'){
                    count++;
                    bfs(r,c,grid);
                }
            }
        }
        return count;
    }
    public void bfs(int r,int c ,char[][] grid){
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        grid[r][c]='0';
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0&&nc>=0&&nr<rows&&nc<cols&&grid[nr][nc]=='1'){
                    grid[nr][nc]='0';
                    q.offer(new int[]{nr,nc});
                }
            }
        }

    }
}
