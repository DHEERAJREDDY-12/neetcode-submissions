class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());

        }
        int[] indeg=new int[numCourses];
        for(int[] p:prerequisites){
            int course=p[0];
            int prereq=p[1];
            adj.get(prereq).add(course);
            indeg[course]++;;

        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int completed=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            completed++;
            for(int nei:adj.get(curr)){
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.offer(nei);
                }
            }
        }
        return completed==numCourses;
    }
}
