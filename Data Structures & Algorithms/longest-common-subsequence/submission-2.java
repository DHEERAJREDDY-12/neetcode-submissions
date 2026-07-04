class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[] dp=new int[n+1];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    if(i==0&&j==0){
                        temp[j]=1;
                    }
                    else if(i==0&&j>0){
                        temp[j]=1;
                    }
                    else if(i>0&&j==0){
                        temp[j]=1;
                    }
                    else{
                        temp[j]=dp[j-1]+1;
                    }
                }
                else{
                    if(i==0&&j==0){
                        temp[j]=0;
                    }
                    else if(i==0&&j>0){
                        temp[j]=temp[j-1];
                    }
                    else if(i>0&&j==0){
                        temp[j]=dp[j];
                    }
                    else{
                        temp[j]=Math.max(dp[j],temp[j-1]);
                    }
                    
                }

            }
            dp=temp;
        }
        return dp[n-1];
    }
}
