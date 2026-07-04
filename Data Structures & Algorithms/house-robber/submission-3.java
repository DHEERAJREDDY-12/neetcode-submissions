class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n=nums.length;
        int prev2=0;
        int prev1=nums[0];
        for(int i=1;i<n;i++){
            
            int curr=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
