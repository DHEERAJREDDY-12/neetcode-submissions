class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            while(a!=parent[a]){
                a=parent[a];
            }
            while(b!=parent[b]){
                b=parent[b];
            }
            if(a==b){
                return edge;
            }
            parent[b]=a;
        }
        return new int[]{};
    }  
}
