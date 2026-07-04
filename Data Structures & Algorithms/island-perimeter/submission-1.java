class Solution {
    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    int per=0;
    public int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    per+=4;
                    for(int k=0;k<4;k++){
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]==1){
                            per--;
                        }
                    }

                }
            }
        }
        return per;
    }
    

}