class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String str:wordList){
            set.add(str);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList<>();
        HashSet<String> s=new HashSet<>();
        q.offer(beginWord);
        s.add(beginWord);
        int moves=1;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(endWord)){
                    return moves;
                }
                char[] l=curr.toCharArray();
                for(int j=0;j<beginWord.length();j++){
                    char let=l[j];
                    for(char ch='a';ch<='z';ch++){
                        if(ch==let){
                            continue;

                        }
                        l[j]=ch;
                        String newstr=new String(l);
                        if(set.contains(newstr)&&!s.contains(newstr)){
                            q.offer(newstr);
                            s.add(newstr);
                        }

                    }
                    l[j]=let;
                }  
               
            }
            moves++;
        }
        return 0;
    }
}
