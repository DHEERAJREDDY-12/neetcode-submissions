class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        HashMap<String,Integer> etom=new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> acc=accounts.get(i);
            for(int j=1;j<acc.size();j++){
                String em=acc.get(j);
                
                if(!etom.containsKey(em)) etom.put(em,i);
                else{
                    int p1=i;
                    while(parent[p1]!=p1){
                        parent[p1]=parent[parent[p1]];
                        p1=parent[p1];
                    }
                    int p2=etom.get(em);
                    while(parent[p2]!=p2){
                        parent[p2]=parent[parent[p2]];
                        p2=parent[p2];
                    }
                    if(p1!=p2){
                        parent[p1]=p2;
                    }
                }

            }
        }
        HashMap<Integer,List<String>> ptoe=new HashMap<>();
        for(String email:etom.keySet()){
            int index=etom.get(email);
            while(parent[index]!=index){
                parent[index]=parent[parent[index]];
                index=parent[index];
            }
            ptoe.putIfAbsent(index,new ArrayList<>());
            ptoe.get(index).add(email);
            
        }
        List<List<String>> ans=new ArrayList<>();
        for(int pi:ptoe.keySet()){
            List<String> emails=ptoe.get(pi);
           
            Collections.sort(emails);
            List<String> row=new ArrayList<>();
            row.add(accounts.get(pi).get(0));
            row.addAll(emails);
            ans.add(row);
        }
        return ans;
        
    }
}