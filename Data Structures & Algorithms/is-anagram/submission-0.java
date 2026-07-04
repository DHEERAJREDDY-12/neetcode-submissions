class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
    
        HashMap<Character,Integer> m1=new HashMap<>();
        HashMap<Character,Integer> m2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char ch1=t.charAt(i);
            m1.put(ch,m1.getOrDefault(ch,0)+1);
            m2.put(ch1,m2.getOrDefault(ch1,0)+1);

        }
        if(m1.equals(m2)){
            return true;
        }
        return false;

    }
}
