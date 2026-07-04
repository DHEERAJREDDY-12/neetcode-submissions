class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0;
        int r=nums.length-1;
        for(int num:nums){
            r+=num;
        }
        int ans=0;
        int result=1000001;
        while(l<=r){
            int mid=l+(r-l)/2;
            int count=1;
            int sum=0;
            ans=0;
            for(int num:nums){
                if(sum+num>mid){
                    count++;
                    sum=0;
                }
                sum+=num;
                ans=Math.max(ans,sum);
            }
            if(count<=k){
                r=mid-1;
                result=Math.min(result,ans);
            }
            else{
                l=mid+1;
            }
            System.out.println(ans+","+count);
        }
        return result;
    }
}