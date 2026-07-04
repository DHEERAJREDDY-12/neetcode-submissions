class PrefixTree {
    class Node{
        Node[] links=new Node[26];
        boolean end=false;
    }
    Node root;

    public PrefixTree() {
        root=new Node();
    }

    public void insert(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++){
            int ind=word.charAt(i)-'a';
            if(temp.links[ind]==null){
                temp.links[ind]=new Node();
            }
            temp=temp.links[ind];

        }
        temp.end=true;
    }

    public boolean search(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++){
            int ind=word.charAt(i)-'a';
            if(temp.links[ind]==null){
                return false;
            }
            temp=temp.links[ind];
        }
        return temp.end;
    }

    public boolean startsWith(String prefix) {
        Node temp=root;
        for(int i=0;i<prefix.length();i++){
            int ind=prefix.charAt(i)-'a';
            if(temp.links[ind]==null){
                return false;
            }
            temp=temp.links[ind];
        }
        return true;
    }
}
