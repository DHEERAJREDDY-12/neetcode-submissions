class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] arr=new int[k][2];
        for(int i=0;i<points.length;i++){
            int a=(int) (Math.pow(points[i][0],2)+Math.pow(points[i][1],2));
            pq.offer(new int[]{a,i});
            
        
        }
        for(int i=0;i<k;i++){
            int[] ar=pq.poll();
            int ind=ar[1];
            arr[i][0]=points[ind][0];
            arr[i][1]=points[ind][1];
        }
        return arr;

    }
}
