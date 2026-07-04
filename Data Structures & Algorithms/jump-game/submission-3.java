class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        int ind=0;
        while(ind<nums.length){
            if(nums[ind]==0){
                if(max>ind){
                    ind++;
                }
                else if(ind==nums.length-1){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                max=Math.max(max,ind+nums[ind]);
                ind++;
            }
            
        }
        return true;
    }
}
