class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len==1){
            return s;
        }
        int a=-1,b=-1;
        int[][] dp=new int[len][len];
        for(int l=0;l<len;l++){
            for(int j=0;j+l<len;j++){

                if(l>=2){
                    if(dp[j+1][j+l-1]==1&& s.charAt(j)==s.charAt(j+l)){
                        dp[j][j+l]=1;
                        a=j;
                        b=j+l;
                    }
                }
                else if(s.charAt(j)==s.charAt(j+l)){
                    dp[j][j+l]=1;
                    a=j;
                    b=j+l;
                }

            }
        }
        return s.substring(a,b+1);
    }
}
