class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int l=0;
        
        int max=0;
        for(int r=0;r<s.length();r++){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                
            }
            else{
                while(s.charAt(l)!=s.charAt(r)){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(s.charAt(l));
                l++;
                set.add(s.charAt(r));
                
            }   
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}
