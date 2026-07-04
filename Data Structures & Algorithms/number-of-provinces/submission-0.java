class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] parent=new int[isConnected.length];
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        int ans=isConnected.length;
        int ind=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int a=i;
                int b=j;
                int c=isConnected[i][j];
                if(c==1){
                    while(a!=parent[a]){
                        a=parent[a];
                    }
                    while(b!=parent[b]){
                        b=parent[b];
                    }
                    if(a!=b){
                        ans--;
                        parent[b]=a;
                    }   
                }
            }
        }
        return ans;
    }
}