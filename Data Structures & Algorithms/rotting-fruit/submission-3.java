class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }
                if(grid[i][j]==1){
                    cnt++;
                }
                
            }
        }

        int maxtime=0;
        while(!q.isEmpty()){
            int[] dr={0,0,-1,1};
            int[] dc={-1,1,0,0};
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            int time=arr[2];
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    cnt--;
                    q.offer(new int[]{nr,nc,time+1});
                    maxtime=Math.max(maxtime,time+1);
                }
            }
        }
        if(cnt==0) return maxtime;
        return -1;

    }
}
