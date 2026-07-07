class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        int count=0;
        int l=0;
        for(int r=0;r<fruits.length;r++){
            
            if(!map.containsKey(fruits[r])){
                map.put(fruits[r],1);
            }
            else map.put(fruits[r],map.get(fruits[r])+1);
            count++;
            while(map.size()>2){
                if(map.containsKey(fruits[l])){
                    if(map.get(fruits[l])>1) map.put(fruits[l],map.get(fruits[l])-1);
                    else map.remove(fruits[l]);
                    count--;
                    l++;
                }
            }
            max=Math.max(count,max);
            
        }
        return max;
    }
}