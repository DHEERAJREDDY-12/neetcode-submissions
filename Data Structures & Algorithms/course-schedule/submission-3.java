class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[numCourses];
        for(int[] prereq:prerequisites){
            int a=prereq[0];
            int b=prereq[1];
            adj.get(b).add(a);
            indeg[a]++;
            
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
            }

        }
        int count=0;
        while(!q.isEmpty()){
            int pre=q.poll();
            count++;
            for(int sub:adj.get(pre)){
                indeg[sub]-=1;
                if(indeg[sub]==0){
                    
                    q.offer(sub);
                }
            }
        }
        return numCourses==count;
    }
}
