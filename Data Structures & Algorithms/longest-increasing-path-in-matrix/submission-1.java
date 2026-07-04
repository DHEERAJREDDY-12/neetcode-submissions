class Solution {
    int[][] dp;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dfs(i,j,matrix));
            }
        }
        return max;
    }
    public int dfs(int i,int j,int[][] matrix){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int max=1;
        for(int k=0;k<4;k++){
            int nr=i+dr[k];
            int nc=j+dc[k];
            if(nc>=0&&nr>=0&&nc<n&&nr<m&&matrix[nr][nc]>matrix[i][j]){
                max=Math.max(max,1+dfs(nr,nc,matrix));

            }
        }
        return dp[i][j]=max;
    }
}
