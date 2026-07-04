class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        int ind=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                count++;
                ind++;
            }
            else if(nums[i]==nums[i-1]){
                continue;
            }
            else{
                nums[ind]=nums[i];
                ind++;
                count++;
            }
        }
        return count;
    }
}