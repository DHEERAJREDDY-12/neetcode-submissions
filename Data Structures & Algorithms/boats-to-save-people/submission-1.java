class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int count=0;
        int l=0;
        int r=nums.length-1;
        Arrays.sort(nums);
        while(l<=r){
            if(nums[l]+nums[r]<=limit){  
                l++;
                r--;
                count++;  
            }
            else{
                r--;
                count++;
            }
        }
        return count;
    }
}