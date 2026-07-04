class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[k];
        int ind=0;
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],1);
            map.put(nums[i],map.get(nums[i])+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> e:list){
            if(ind<k){
                ans[ind++]=e.getKey();
            }
            
        }
        return ans;
    }

}
