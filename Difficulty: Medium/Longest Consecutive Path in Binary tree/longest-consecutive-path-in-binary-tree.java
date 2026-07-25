/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    int rec(Node root,int cnt)
    {
        if(root==null)
        return cnt;
        int ans=cnt;
        if(root.left!=null)
        {
            if(root.left.data-root.data==1)
            ans=Math.max(ans,rec(root.left,cnt+1));
            else
            {
                ans=Math.max(ans,cnt);
                ans=Math.max(ans,rec(root.left,1));
            }
        }
        if(root.right!=null)
        {
            if(root.right.data-root.data==1)
            ans=Math.max(ans,rec(root.right,cnt+1));
            else
            {
                ans=Math.max(ans,cnt);
                ans=Math.max(ans,rec(root.right,1));
            }
        }
        return ans;
    }
    public int longestConsecutive(Node root) {
        // code here
        int val= rec(root,1);
        return (val==1)?-1:val;
    }
}