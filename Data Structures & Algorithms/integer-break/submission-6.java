class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        
        for(int i=2;i<=n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                max=Math.max(max,Math.max(j,dp[j])*(i-j));
            }
            dp[i]=max;
        }
        return dp[n];
    }
}