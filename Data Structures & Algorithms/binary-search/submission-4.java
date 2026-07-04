class Solution {
    public int search(int[] nums, int target) {
        if(target>nums[nums.length-1]){
            return -1;
        }
        int l=0;
        int r=nums.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                r=mid-1;

            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}
