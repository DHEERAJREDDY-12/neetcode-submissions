class Solution {
    public int maxProfit(int[] nums) {
        int max=0;
        if(nums.length==1){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                max+=(nums[i]-nums[i-1]);
            }
        }
        return max;
    }
}