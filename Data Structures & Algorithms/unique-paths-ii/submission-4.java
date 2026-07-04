class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0]==1){
            return 0;
        }
        int[] dp=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    dp[i]=1;
                }
                else{
                    if(obstacleGrid[i][j]==0){
                        
                        if(j-1>=0){
                            dp[j]=dp[j]+dp[j-1];
                        }

                    }
                    else{
                        dp[j]=0;
                    }
                }
            }
        }
        return dp[n-1];
    }
}