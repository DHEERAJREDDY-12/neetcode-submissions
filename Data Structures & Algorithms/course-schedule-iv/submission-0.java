class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses,int[][] prerequisites,int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];
            adj.get(a).add(b);
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int prereq = query[0];
            int course = query[1];
            Queue<Integer> q = new LinkedList<>();
            boolean[] vis = new boolean[numCourses];
            q.offer(prereq);
            vis[prereq] = true;
            boolean found = false;
            while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == course) {
                    found = true;
                    break;
                }
                for (int nei : adj.get(cur)){
                    if (!vis[nei]) {
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }  
            }
            result.add(found);
            
        }
        return result;
    }
}