class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<m;i++){
            int[] temp=new int[n];
            temp[0]=1;
            for(int j=1;j<n;j++){
                temp[j]=temp[j-1]+dp[j];
            }
            dp=temp;
        }
        return dp[n-1];
    }
}
