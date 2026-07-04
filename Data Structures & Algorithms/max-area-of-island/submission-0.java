class Solution {
    int[] dr={0,0,-1,1};
    int[] dc={-1,1,0,0};
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int max=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    max=Math.max(max,bfs(r,c,grid));
                }
            }
        }
        return max;
    }
    public int bfs(int r,int c,int[][] grid){
        int rows=grid.length;
        int cols=grid[0].length;
        grid[r][c]=0;
        int area=1;
        Queue<int []> q= new LinkedList<>();
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int row=cur[0];
            int col=cur[1];
            for(int i=0;i<4;i++){
                int nr=dr[i]+row;
                int nc=dc[i]+col;
                if(nr>=0&&nc>=0&&nr<rows&&nc<cols&&grid[nr][nc]==1){
                    grid[nr][nc]=0;
                    area++;
                    q.offer(new int[]{nr,nc});
                }
            }

        }
        return area;
    }
}
