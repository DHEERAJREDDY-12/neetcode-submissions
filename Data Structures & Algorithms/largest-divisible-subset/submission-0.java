class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> dp=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>());
            dp.get(i).add(nums[i]);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp.get(j).size()+1>dp.get(i).size()){
                        dp.set(i, new ArrayList<>(dp.get(j)));
                        dp.get(i).add(nums[i]);
                    }
                }
            }
            if(dp.get(i).size()>ans.size()){
                ans=dp.get(i);
            }
        }
        return ans;
    }
}