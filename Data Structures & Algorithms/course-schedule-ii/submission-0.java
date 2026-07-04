class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] result=new int[numCourses];
        int index=0;
        int[] indeg=new int[numCourses];
        for(int[] p:prerequisites){
            int a=p[0];
            int b=p[1];
            adj.get(b).add(a);
            indeg[a]++;
        }
        int completed=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
                result[index++]=i;
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            completed++;
            for(int nei: adj.get(curr)){
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.offer(nei);
                    result[index++]=nei;
                }
            }
        }
        if(completed==numCourses){
            return result;
        }
        return new int[0];

    }
}
