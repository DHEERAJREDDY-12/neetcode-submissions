class Solution {
    public int maxProduct(int[] nums) {
        int maxx=nums[0];
        int curMin=nums[0];
        int curMax=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            int min=curMin*nums[i];
            int max=curMax*nums[i];
            curMin=Math.min(min,Math.min(max,nums[i]));
            curMax=Math.max(min,Math.max(max,nums[i]));
            maxx=Math.max(maxx,Math.max(curMin,curMax));
        }
        return maxx;
    }
}
