class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            adj.get(b).add(a);
            adj.get(a).add(b);
        }
        int[] vis=new int[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        vis[0]=1;
        int count=1;
        int connected=1;
        while(count<n){
            while(!q.isEmpty()){
                int a=q.poll();
                
                for(int b:adj.get(a)){
                    if(vis[b]==0){
                        vis[b]=1;
                        count+=1;
                        q.offer(b);                        
                    }
                }
            }
            if(count<n){
                connected+=1;
                for(int i=0;i<n;i++){
                    if(vis[i]==0){
                        vis[i]=1;
                        count+=1;
                        q.offer(i);
                        break;
                    }
                }
            }
        
        }
        return connected;
        
    }
}
