class Solution {
    Queue<int[]> queue=new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        boolean found=false;
        for(int i=0;i<m;i++){
            if(found) break;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                    queue.offer(new int[]{i,j});
                    found=true;
                    grid[i][j]=2;
                    break;
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            
            int[] dr={0,0,-1,1};
            int[] dc={-1,1,0,0};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]==1){
                    q.offer(new int[]{nr,nc});
                    queue.offer(new int[]{nr,nc});
                    grid[nr][nc]=2;
                }
            }
        }
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                int[] dr={0,0,-1,1};
                int[] dc={-1,1,0,0};
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 2) {
                        continue;
                    }

                    if (grid[nr][nc] == 1) {
                        return steps;
                    }

                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                }
            }

            steps++;
        }
        return -1;
        

    }
}