class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int[] finds=new int[n+1];
        for(int[] t:trust){
            int a=t[0];
            int b=t[1];
            finds[a]++;
            map.putIfAbsent(b,new ArrayList<>());
            map.get(b).add(a);
        }
        for(int i=1;i<=n;i++){
            int find=map.containsKey(i)?map.get(i).size():0;
            if(finds[i]==0&&find==n-1){
                return i;
            }
        }
        return -1;
    }
}