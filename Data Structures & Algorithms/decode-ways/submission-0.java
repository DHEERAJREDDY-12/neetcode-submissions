class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int n=s.length();
        if(n==1){
            return 1;
        }
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            int num=(int)(s.charAt(i)-'0');
            if(num>0){
                if(i==0){
                    dp[i]=1;
                }
                else{
                    dp[i]=dp[i]+dp[i-1];
                }
            }
            if(i>0){
                int num1=(int) (s.charAt(i-1)-'0');
                if((num1*10+num)>=10&&(num1*10+num)<=26){
                    if(i<2){
                        dp[i]=dp[i]+1;
                    }
                    else{
                        dp[i]=dp[i]+dp[i-2];
                    }
                }
            }
        }
        return dp[n-1];

    }
}
