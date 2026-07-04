class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[numCourses];
        for(int[] prereq:prerequisites){
            int sub=prereq[0];
            int pre=prereq[1];
            adj.get(pre).add(sub);
            indeg[sub]++;
        }
        int[] ans=new int[numCourses];
        int ind=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
                ans[ind++]=i;
            }

        }
        
        while(!q.isEmpty()){
            int pre=q.poll();
            for(int sub:adj.get(pre)){
                indeg[sub]-=1;
                if(indeg[sub]==0){
                    ans[ind++]=sub;
                    q.offer(sub);
                }
            }
            
        }
        return numCourses==ind?ans:new int[0];
    }
}
