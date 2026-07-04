class Solution {
    public int maxSubArray(int[] nums) {
        int l=0;
        int r=0;
        int max=nums[0];
        int n=nums.length;
        while(r<=n-1){
            int sum=0;
            for(int i=l;i<=r;i++){
                sum+=nums[i];
            }
            if(sum<=nums[r]){
                l=r;
                sum=nums[r];
            }
            System.out.println(sum);
            r++;
            max=Math.max(max,sum);
        }
        return max;
    }
}
