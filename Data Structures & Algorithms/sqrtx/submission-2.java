class Solution {
    public int mySqrt(int x) {
        int l=0;
        int r=x;
        while(l<r){
            int mid=l+(r-l)/2;
            long mid2=(long)mid*mid;
            if(mid2==x){
                return mid;
            }
            else if(mid2>x){
                r=mid-1;

            }
            else{
                l=mid+1;
            }
            System.out.println(mid+","+mid2);
        }
        if(l*l>x) return l-1;
        return l;
    }
}