class Solution {
    static int rec(int ind,int m,int n,int pe,int dp[][])
    {
        if(ind>=n)
        return 1;
        if(dp[ind][pe+1]!=-1)
        return dp[ind][pe+1];
        int ans=0;
        if(pe==-1)
        {
            for(int i=1;i<=m;i++)
            ans+=rec(ind+1,m,n,i,dp);
        }
        else
        {
            for(int i=1;i<=m;i++)
            {
                if(pe%i==0 || i%pe==0)
                ans+=rec(ind+1,m,n,i,dp);
            }
        }
        return dp[ind][pe+1]=ans;
    }
    public int count(int n, int m) {
        // code here
        int dp[][]=new int[n][m+2];
        for(int i[]: dp)
        Arrays.fill(i,-1);
        return rec(0,m,n,-1,dp);
    }
}