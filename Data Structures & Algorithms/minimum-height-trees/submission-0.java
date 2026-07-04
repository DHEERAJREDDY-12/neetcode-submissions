class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return Arrays.asList(0);
        }
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int[] degree=new int[n];
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            map.putIfAbsent(a,new ArrayList<>());
            map.putIfAbsent(b,new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
            degree[a]+=1;
            degree[b]+=1;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        int rem=n;
        
        while(rem>2){
            int size=q.size();
            rem-=size;
            for(int i=0;i<size;i++){
                int num=q.poll();
                if(!map.containsKey(num)) continue;
                degree[num]-=1;
                for(int no:map.get(num)){
                    degree[no]-=1;
                    if(degree[no]==1){
                        q.offer(no);
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int po=q.poll();
            ans.add(po);
        }
            
        return ans;
            
        

    }
}