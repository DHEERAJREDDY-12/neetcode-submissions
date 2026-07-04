class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq1=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<profits.length;i++){
            pq.offer(new int[]{capital[i],profits[i]});
        }
        int ans=w;
        while(k>0){
            while(!pq.isEmpty()&&pq.peek()[0]<=ans){
                pq1.offer(pq.poll()[1]);   
            }
            if(pq1.isEmpty()){
                return ans;
            }
            ans+=pq1.poll();
            k--;
        }

        return ans;

    }
}