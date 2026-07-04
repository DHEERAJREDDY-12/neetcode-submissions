class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=100001;
        int l=0;
        int sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>=target){
                sum-=nums[l];
                l++;
                min=Math.min(min,r-l+1);
            }
            
        }
        if(min==100001){
            return 0;
        }
        return min+1;
        
    }
}