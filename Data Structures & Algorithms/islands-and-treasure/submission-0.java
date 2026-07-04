class Solution {
    int[] dr={0,0,-1,1};
    int[] dc={-1,1,0,0};
    public void islandsAndTreasure(int[][] grid) {
        int rows =grid.length;
        int cols=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==0){
                    q.offer(new int[]{r,c});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0];
            int c=cur[1];
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nc>=0&&nr<rows&&nc<cols&&grid[nr][nc]==2147483647){
                    grid[nr][nc]=grid[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }
    
}
