class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{0,i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int dis=arr[0];
            int r=arr[1];
            int c=arr[2];
            int[] dr={0,0,-1,1};
            int[] dc={-1,1,0,0};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nc>=0&&nr<m&&nc<n&&(dis+1)<grid[nr][nc]){
                    grid[nr][nc]=dis+1;
                    q.offer(new int[]{grid[nr][nc],nr,nc});
                    
                }
            }
        }
    }
}
