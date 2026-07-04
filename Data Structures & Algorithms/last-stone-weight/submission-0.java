class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int num:stones){
            pq.offer(num);
        }
        
        while(pq.size()>=2){
            int a=pq.poll();
            int b=pq.poll();
            if(a!=b){
                pq.offer(a-b);
            }
        }
        if(pq.size()==1){
            return pq.poll();
        }
        return 0;
        
    }
}
