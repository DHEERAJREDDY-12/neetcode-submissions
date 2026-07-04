class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        int primeind=(int) Math.sqrt(n);
        int[] arr=new int[primeind+1];
        for(int i=1;i<=primeind;i++){
            arr[i]=i*i;
        }
        for(int i=2;i<=n;i++){
            int min=10001;
            for(int num:arr){
                if(num==0){
                    continue;
                }
                else if(i>=num){
                    min=Math.min(min,dp[i-num]+1);
                }
            }
            dp[i]=min;
        }
        return dp[n];
    }
}