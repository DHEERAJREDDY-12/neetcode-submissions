class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        String ans="";
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(Character ch:s.toCharArray()){
            map.putIfAbsent(ch,0);
            map.put(ch,map.get(ch)+1);
            if(map.get(ch)>(n+1)/2){
                return "";
            }
        }
        for(char ch:map.keySet()){
            pq.offer(new int[]{map.get(ch),ch});
        }
        while(pq.size()>1){
            int[] a1=pq.poll();
            int[] a2=pq.poll();
            ans+=(char)a1[1];
            ans+=(char)a2[1];
            a1[0]--;
            a2[0]--;
            if(a1[0]>0){
                pq.offer(a1);
            }
            if(a2[0]>0){
                pq.offer(a2);
            }
        }
        if(!pq.isEmpty()){
            int[] last=pq.poll();
            ans+=(char)last[1];
        }
        return ans;



    }
}