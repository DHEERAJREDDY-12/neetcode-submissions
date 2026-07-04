class Solution {
    List<List<Integer>> arr=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums,new ArrayList<>());
        return arr;
    }
    void dfs(int ind,int[] nums,List<Integer> temp){
        arr.add(new ArrayList<>(temp));
        for(int i=ind;i<nums.length;i++){
            if(i>ind&&nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            dfs(i+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }
}
