class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans=new int[nums.length];
        ans[0]=1;
        int pre=1;
        int suf=1;
        for(int i=1;i<nums.length;i++){
            ans[i]=nums[i-1]*pre;
            pre=ans[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            ans[i]=ans[i]*suf;
            suf=suf*nums[i];
        }
        return ans;
        
    }
}  
