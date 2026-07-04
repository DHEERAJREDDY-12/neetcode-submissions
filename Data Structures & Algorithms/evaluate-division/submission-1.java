class Pair{
    double value;
    String str;
    Pair(double value,String str){
        this.value=value;
        this.str=str;
    }
    
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>> map=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            double c=values[i];
            map.putIfAbsent(a,new ArrayList<>());
            map.get(a).add(new Pair(c,b));
            map.putIfAbsent(b,new ArrayList<>());
            map.get(b).add(new Pair(1.0/c,a));
        }
        double[] ans=new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            Queue<Pair> q=new LinkedList<>();
            String a=queries.get(i).get(0);
            String b=queries.get(i).get(1);
            if(!map.containsKey(a)||!map.containsKey(b)){
                ans[i]=-1.0;
                continue;
            }
            HashSet<String> vis=new HashSet<>();
            List<Pair> pairs=map.get(a);
            q.offer(new Pair(1.0,a));
            vis.add(a);
            boolean found=false;
            while(!q.isEmpty()){
                Pair cur=q.poll();
                if(cur.str.equals(b)){
                    ans[i]=cur.value;
    
                    
                    found=true;
                    break;
                }
                for(Pair pa:map.get(cur.str)){
                    if(!vis.contains(pa.str)){
                        vis.add(pa.str);
                        q.offer(new Pair(cur.value*pa.value,pa.str));
                    }
                    
                }
            }
            if(!found){
                ans[i]=-1.0;
            }
            
        }
        return ans;

    }
}