class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int max=-1;
        int a=nums[0];
        int b=Math.max(nums[0],nums[1]);
        for(int i=2;i<n-1;i++){
            int c=Math.max(a+nums[i],b);
            a=b;
            b=c;
           
        }
        max=Math.max(max,b);
        int c=nums[1];
        int d=Math.max(nums[1],nums[2]);
        for(int i=3;i<n;i++){
            int e=Math.max(c+nums[i],d);
            c=d;
            d=e;
        }
        max=Math.max(max,d);
        return max;
    }
}
