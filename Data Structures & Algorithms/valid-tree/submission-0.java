class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] vis=new int[n];
        for(int[] a:edges){
            int b=a[0];
            int c=a[1];
            adj.get(b).add(c);
            adj.get(c).add(b);
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        vis[0]=1;
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int ne:adj.get(cur)){
                if(vis[ne]==0){
                    vis[ne]=1;
                    q.offer(ne);
                }
            }
        }
        for(int ne:vis){
            if(ne==0){
                return false;
            }
        }
        return true;
    }
}
