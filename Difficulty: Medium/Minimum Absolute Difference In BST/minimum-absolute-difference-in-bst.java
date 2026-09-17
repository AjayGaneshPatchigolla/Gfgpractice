/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int ans,pv;
    void rec(Node root)
    {
        if(root==null)
        return;
        rec(root.left);
        if(pv!=Integer.MAX_VALUE)
        ans=Math.min(ans,root.data-pv);
        pv=root.data;
        rec(root.right);
    }
    public int absDiff(Node root) {
        // code here
        pv=Integer.MAX_VALUE;
        ans=Integer.MAX_VALUE;
        rec(root);
        return ans;
    }
}
