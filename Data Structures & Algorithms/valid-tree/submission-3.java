class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] vis=new int[n];

        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        int count=0;
        while(!q.isEmpty()){
            int a=q.poll();
            vis[a]=1;
            count+=1;
            for(int b:adj.get(a)){
                if(vis[b]==0){
                    q.offer(b);
                }
                
            }
        }

        return n==count;
    }
}
