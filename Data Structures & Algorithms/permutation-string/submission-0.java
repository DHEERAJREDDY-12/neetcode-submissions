class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l=0;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char c:s1.toCharArray()){
            if(map1.get(c)==null){
                map1.put(c,1);
            }
            else{
                map1.put(c,map1.get(c)+1);
            }
        }
        for(int r=0;r<s2.length();r++){
            map2.put(s2.charAt(r),map2.getOrDefault(s2.charAt(r),0)+1);
            if(r-l+1>s1.length()){
                map2.put(s2.charAt(l),(map2.get(s2.charAt(l))-1));
                if(map2.get(s2.charAt(l))==0){
                    map2.remove(s2.charAt(l));
                }
                l++;
            }
            if(r-l+1==s1.length()&&(map1.equals(map2))){
                return true;
            }
        }
        return false;
    }
}
