class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int[] trip:trips){
            int a=trip[0];
            int b=trip[1];
            int c=trip[2];
            for(int i=b;i<c;i++){
                map.putIfAbsent(i,0);
                map.put(i,map.get(i)+a);
                if(map.get(i)>capacity){
                    return false;
                }
            }
            map.putIfAbsent(c,0);
            map.put(c,map.get(c)-a);
        }
        return true;
    }
}