class Pair{
    int timestamp;
    String value;

    Pair(int timestamp,String value){
        this.timestamp=timestamp;
        this.value=value;
    }
}
class TimeMap {
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        int l=0;
        List<Pair> list=map.get(key);
        int r=list.size()-1;
        String ans="";
        while(l<=r){
            int mid=l+(r-l)/2;
            if(list.get(mid).timestamp==timestamp){
                return list.get(mid).value;
            }

            else if(list.get(mid).timestamp<timestamp){
                ans=list.get(mid).value;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}
