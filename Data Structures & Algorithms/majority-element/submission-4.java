class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        int n=nums[0];
        for(int num:nums){
            if(num==n){
                if(count==0){
                    n=num;
                    count=1;
                }
                else{
                    count++;
                }   
            }
            else{
                count=count-1;
                if(count==0){
                    n=num;
                    count=1;
                }
            }
        }
        return n;
    }
}