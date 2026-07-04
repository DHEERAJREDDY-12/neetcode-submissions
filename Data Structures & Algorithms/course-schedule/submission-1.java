class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[numCourses];
        for(int[] pre:prerequisites){
            int course=pre[0];
            int prereq=pre[1];
            indeg[course]++;
            adj.get(prereq).add(course);
        }
        int completed=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int c=q.poll();
            completed++;
            for(int co:adj.get(c)){
                indeg[co]--;
                if(indeg[co]==0){
                    q.offer(co);
                }
            }
        }
        return numCourses==completed;


    }
}
