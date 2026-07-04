class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=0;
        for(int pile:piles){
            r=Math.max(r,pile);
        }
        int ans=1000000;
        while(l<=r){
            int mid=l+(r-l)/2;
            int count=0;
            for(int pile:piles){
                count += (pile + mid - 1) / mid;
            }
            if(count<=h){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
            
        }
        return ans;

    }
}
