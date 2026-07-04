class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1){

        }
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int l=0;
        int r=0;
        int ind=0;
        int max=Integer.MIN_VALUE;
    
        while(r-l<k){
            if(max<=nums[r]){
                max=nums[r];
            }
            r++;        
        }
        
        while(r<n){
            ans[ind++]=max;
            if(nums[r]>=max){
                max=nums[r];
                r++;
            }
            else{
                if (nums[l] == max) {
                    max = nums[l + 1];
                    for (int i = l + 2; i <= r; i++) {
                        if (nums[i] > max) {
                            max = nums[i];
                        }
                    }
                }
                r++;
            }
            l++;

        }
        ans[ind]=max;
        return ans;
    }
}
