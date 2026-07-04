class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            if(find(a)==find(b)){
                return edge;
            }
            union(a,b);

        }
        return new int[0];
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void union(int a,int b){
        int pa=find(a);
        int pb=find(b);
        if(pa!=pb){
            parent[pb]=pa;
        }
    }
}
