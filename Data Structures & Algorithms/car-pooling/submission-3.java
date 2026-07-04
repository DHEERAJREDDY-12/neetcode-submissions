class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int curr=0;
        for(int trip[]:trips){
            int a=trip[0];
            int b=trip[1];
            int c=trip[2];
            map.putIfAbsent(b,0);
            map.put(b,map.get(b)+a);
            map.putIfAbsent(c,0);
            map.put(c,map.get(c)-a);
        }
        for(int loc:map.keySet()){
            curr+=map.get(loc);
            if(curr>capacity){
                return false;
            }
        }
        return true;
    }
}