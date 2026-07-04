class Solution {
    public int countComponents(int n, int[][] edges) {
        int connected=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int a=e[0];
            int b=e[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                connected++;
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int cur=q.poll();
                    for(int nei:adj.get(cur)){
                        if(vis[nei]!=1){
                            vis[nei]=1;
                            q.offer(nei);
                        }
                    }
                }
            }
        }
        return connected;
       
    }
}
