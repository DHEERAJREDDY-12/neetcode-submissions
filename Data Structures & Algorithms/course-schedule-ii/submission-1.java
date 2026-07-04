class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg=new int[numCourses];
        for(int[] pre:prerequisites){
            int prereq=pre[1];
            int course=pre[0];
            adj.get(prereq).add(course);
            indeg[course]++;
        }
        int[] result=new int[numCourses];
        int ind=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
                result[ind++]=i;
            }
        }
        while(!q.isEmpty()){
            int p=q.poll();
            for(int c:adj.get(p)){
                indeg[c]--;
                if(indeg[c]==0){
                    result[ind++]=c;
                    q.offer(c);
                }
            }
        }
        if(ind==numCourses){
            return result;
        }
        return  new int[0];
    }
}
