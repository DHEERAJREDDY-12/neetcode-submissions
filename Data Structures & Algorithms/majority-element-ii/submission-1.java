class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.putIfAbsent(num,0);
            map.put(num,map.get(num)+1);
            if(map.get(num)>(nums.length)/3&&(!ans.contains(num))){
                ans.add(num);
            }
        }
        return ans;

    }
}