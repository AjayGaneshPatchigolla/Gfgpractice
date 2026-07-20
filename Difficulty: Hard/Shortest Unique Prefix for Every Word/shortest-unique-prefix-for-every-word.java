class Solution {
    class Node
    {
        Node child[];
        boolean end;
        int cnt;
        Node()
        {
            child=new Node[26];
            end=false;
            cnt=0;
        }
    }
    class Trie
    {
        Node root;
        Trie()
        {
            root=new Node();
        }
        void insert(String s)
        {
            Node tmp=root;
            for(int i=0;i<s.length();i++)
            {
                char c=s.charAt(i);
                if(tmp.child[c-'a']==null)
                tmp.child[c-'a']=new Node();
                tmp=tmp.child[c-'a'];
                tmp.cnt+=1;
            }
            tmp.end=true;
        }
        
        String shortPrefix(String s)
        {
            Node tmp=root;
            String res="";
            for(int i=0;i<s.length();i++)
            {
                char c=s.charAt(i);
                // System.out.print(c+" ");
                res+=c;
                if(tmp.child[c-'a'].cnt==1)
                break;
                tmp=tmp.child[c-'a'];
            }
            return res;
        }
    }
    public ArrayList<String> findPrefixes(String[] arr) {
        // code here
        ArrayList<String> ans=new ArrayList<>();
        Trie trie=new Trie();
        for(String i: arr)
        trie.insert(i);
        for(String i: arr)
        {
            ans.add(trie.shortPrefix(i));
        }
        return ans;
    }
}