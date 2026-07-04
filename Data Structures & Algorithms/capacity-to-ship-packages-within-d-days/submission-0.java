class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=1;
        int r=0;
        for(int wei:weights){
            r+=wei;
            l=Math.max(wei,l);
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            int count=0;
            int size=0;
            for(int i=0;i<weights.length;i++){
                if(size+weights[i]>mid){
                    count++;
                    size=0;
                }
                size+=weights[i];
            }
            count++;
            if(count>days){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
}