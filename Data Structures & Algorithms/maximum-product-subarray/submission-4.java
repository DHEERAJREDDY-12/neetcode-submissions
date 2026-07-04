class Solution {
    public int maxProduct(int[] nums) {
        int minsum=nums[0];
        int maxsum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            int oldmax=maxsum;
            int oldmin=minsum;
            
            
            minsum=Math.min(num,Math.min(oldmin*num,oldmax*num));
            maxsum=Math.max(num,Math.max(oldmin*num,oldmax*num));
            max=Math.max(max,maxsum);
        }
        return Math.max(max,maxsum);
    }
}
