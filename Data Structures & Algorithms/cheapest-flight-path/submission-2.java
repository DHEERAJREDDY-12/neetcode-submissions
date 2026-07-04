class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,List<int[]>> map=new HashMap<>();
        for(int[] flight:flights){
            int a=flight[0];
            int b=flight[1];
            int cost=flight[2];
            map.putIfAbsent(a,new ArrayList<>());
            map.get(a).add(new int[]{b,cost});
        }
        int[] cost=new int[n];
        int[] stops=new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        Arrays.fill(stops,Integer.MAX_VALUE);
        stops[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,src,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int cos=arr[0];
            int sr=arr[1];
            int us=arr[2];
            if(sr==dst){
                return cos;
            }
            if(!map.containsKey(sr)){
                continue;
            }
            if(map.containsKey(sr)){
                for(int[] ar:map.get(sr)){
                    int de=ar[0];
                    int co=ar[1];
                    if(us+1<=k+1&&(cos+co<cost[de]||us+1<stops[de])){
                        pq.offer(new int[]{co+cos,de,us+1});
                    }
                    
                }
            }
            
        }
        return -1;
    }
}
