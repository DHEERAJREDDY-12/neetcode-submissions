class Solution {
    public int tribonacci(int n) {
        int prev1=1;
        int prev2=1;
        int prev3=0;
        if(n<3){
            if(n>0) return 1;
            else return 0;
        }
        for(int i=3;i<=n;i++){
            int curr=prev3+prev2+prev1;
            prev3=prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}