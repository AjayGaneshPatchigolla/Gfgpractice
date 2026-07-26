class Solution {
    public int maximumSum(int[][] mat, int k) {
        // code here
        int s=0,r=mat.length,ans=Integer.MIN_VALUE;
        for(int i=0;i<r;i++)
        {
            int ts=0;
            for(int j=0;j<r;j++)
            {
                ts+=mat[i][j];
                mat[i][j]=ts;
            }
        }
        for(int j=0;j<r;j++)
        {
            int ts=0;
            for(int i=0;i<r;i++)
            {
                ts+=mat[i][j];
                mat[i][j]=ts;
            }
        }
        for(int i=k-1;i<r;i++)
        {
            for(int j=k-1;j<r;j++)
            {
                s=mat[i][j];
                if(i>=k)
                s-=mat[i-k][j];
                if(j>=k)
                s-=mat[i][j-k];
                if(i>=k && j>=k)
                s+=mat[i-k][j-k];
                ans=Math.max(ans,s);
            }
        }
        return ans;
    }
}