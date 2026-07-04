class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<int[]>> map=new HashMap<>();
        for(int[] time:times){
            int a=time[0];
            int b=time[1];
            int c=time[2];
            map.putIfAbsent(a,new ArrayList<>());
            map.get(a).add(new int[]{b,c});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int nod=arr[0];
            int dis=arr[1];
            if(dis>dist[nod]){
                continue;
            }
            if(map.containsKey(nod)){
                for(int[] nodes:map.get(nod)){
                    int node=nodes[0];
                    int d=nodes[1];
                    
                    if(dis+d<dist[node]){
                        dist[node]=dis+d;
                        pq.offer(new int[]{node,dist[node]});
                    }
                }
            }  
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}
