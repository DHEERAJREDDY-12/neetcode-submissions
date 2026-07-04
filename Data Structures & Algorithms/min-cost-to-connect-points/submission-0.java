class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int connected=0;
        boolean[] vis=new boolean[points.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});
        
        int ans=0;
        while(connected!=n){
            int[] p=pq.poll();
            if(vis[p[1]]) continue;
            vis[p[1]]=true;
            connected+=1;
            ans+=p[0];
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    int dist=Math.abs(points[i][0]-points[p[1]][0])+Math.abs(points[i][1]-points[p[1]][1]);
                    pq.offer(new int[]{dist,i});
                }
            }
        }
        return ans;

    }
}
