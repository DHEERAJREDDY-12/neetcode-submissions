class Solution {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->y[0]-x[0]);
        String s="";
        if(a!=0) map.putIfAbsent('a',a);
        if(b!=0) map.putIfAbsent('b',b);
        if(c!=0) map.putIfAbsent('c',c);
        for(Character ch:map.keySet()){
            pq.offer(new int[]{map.get(ch),ch});
        }
        int ind=0;
        while(!pq.isEmpty()){
            int[] d=pq.poll();
            int m=d[0];
            char n=(char) d[1];
            if(s.length()==0){
                if(m>=2){
                    s+=n;
                    ind++;
                    m--;
                    s+=n;
                    ind++;
                    m--;
                    if(m>0){
                        pq.offer(new int[]{m,n});
                    } 
                }
                else{
                    s+=n;
                    ind++;
                }
            }
            else{
                if(n!=(s.charAt(ind-1))){
                    if(m>=2){
                        s+=n;
                        ind++;
                        m--;
                        s+=n;
                        ind++;
                        m--;
                        if(m>0){
                            pq.offer(new int[]{m,n});
                        }
                    }
                    else{
                        s+=n;
                        ind++;
                    }
                }
                else{
                    if(pq.isEmpty()){
                        return s;
                    }
                    int[] e=pq.poll();
                    int k=e[0];
                    char l=(char)e[1];
                    pq.offer(d);
                    s+=l;
                    ind++;
                    k--;
                    if(k>0){
                        pq.offer(new int[]{k,l});
                    }
                
                }

            }
        }
        return s;

    }
}