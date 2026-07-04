class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            dp[1]=100001;
        }
        for(int i=1;i<=amount;i++){
            int min=100001;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&(dp[i-coins[j]]+1<min)){
                    min=dp[i-coins[j]]+1;
                }
            }
            dp[i]=min;
            System.out.println(min);
        }
        if(dp[amount]>=10001){
            return -1;
        }
        return dp[amount];
    }
}
