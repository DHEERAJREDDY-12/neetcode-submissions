/*class Solution {
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

}*/
class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
    
        // Array to hold frequencies of 26 lowercase English letters
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment for string s
            count[t.charAt(i) - 'a']--; // Decrement for string t
        }
        
        // If it's an anagram, all positions in the array must be exactly 0
        for (int val : count) {
            if (val != 0) {
                // Found a mismatch in character counts
                return false; 
            }
        }
        
        return true;
    }
}
