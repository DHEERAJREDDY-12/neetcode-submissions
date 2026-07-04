class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        boolean found=false;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                found=true;
                return mid;
            }
            else if(target>nums[mid]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
        

    }
}