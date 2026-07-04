class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] l=new int[n+1];
        for(int i=0;i<trust.length;i++){
            int a =trust[i][0];
            int b=trust[i][1];
            l[a]--;
            l[b]++;
            
        
        }
        for(int i=0;i<=n;i++){
            if(l[i]==n-1){
                return i;
            }
        }
        return -1;   
    }
}