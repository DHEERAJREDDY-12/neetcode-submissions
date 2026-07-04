class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:hand){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        for(int num:hand){
            if(map.get(num)==0){
                continue;
            }
            for(int i=0;i<groupSize;i++){
                int cur=num+i;
                if(!map.containsKey(cur)||map.get(cur)==0){
                    return false;
                }
                map.put(cur,map.get(cur)-1);
            }

        }
        return true;

    }
}
