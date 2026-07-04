class Solution {
    List<List<Integer>> arr=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0,0,nums,target,new ArrayList<>());
        return arr;
    }
    void dfs(int sum,int ind,int[] nums,int target,List<Integer> temp){
        if(sum==target){
            arr.add(new ArrayList<>(temp));
            return;
        }
        if(sum>target||ind>=nums.length){
            return;
        }
        temp.add(nums[ind]);
        dfs(sum+nums[ind],ind,nums,target,temp);
        temp.remove(temp.size()-1);
        dfs(sum,ind+1,nums,target,temp);

    }
}
