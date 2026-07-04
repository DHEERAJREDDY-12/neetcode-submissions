class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<position.length;i++){
            int arr[]=new int[]{position[i],speed[i]};
            pq.offer(arr);
        }
        Stack<Double> st=new Stack<>();
        while(!pq.isEmpty()){
            int[] arr1=pq.poll();
            int p=arr1[0];
            int s=arr1[1];
            double time=(double) (target-p)/s;
            if(st.isEmpty()||st.peek()<time){
                st.push(time);
            }
        }
        return st.size();
    }
}
