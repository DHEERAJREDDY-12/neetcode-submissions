class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        int offset=sum;
        int[][] dp=new int[n+1][2*sum+1];
        dp[0][offset]=1;
        for(int i=1;i<=n;i++){
            int num=nums[i-1];
            for(int s=-sum;s<=sum;s++){
                if(dp[i-1][s+offset]!=0){
                    dp[i][s+offset+num]+=dp[i-1][s+offset];
                    dp[i][s+offset-num]+=dp[i-1][s+offset];
                }
            }
        }
        return dp[n][target+offset];
    }
}
