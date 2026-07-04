class Solution {
    List<List<Integer>> arr=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(0,nums,new ArrayList<>());
        return arr;
    }
    public void solve(int ind,int[] nums,List<Integer> temp){
        if(ind==nums.length){
            arr.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        solve(ind+1,nums,temp);
        temp.remove(temp.size()-1);
        solve(ind+1,nums,temp);
    }
}
