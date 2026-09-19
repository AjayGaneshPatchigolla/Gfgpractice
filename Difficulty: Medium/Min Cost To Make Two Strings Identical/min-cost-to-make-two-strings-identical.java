class Solution {
    int rec(int i1,int i2,String s1,String s2,int c1,int c2,int dp[][])
    {
        if(i1>=s1.length())
        return c2*(s2.length()-i2);
        if(i2>=s2.length())
        return c1*(s1.length()-i1);
        
        int ans=Integer.MAX_VALUE;
        if(dp[i1][i2]!=-1)
        return dp[i1][i2];
        if(s1.charAt(i1)==s2.charAt(i2))
        ans=Math.min(ans,rec(i1+1,i2+1,s1,s2,c1,c2,dp));
        else
        {
            ans=Math.min(ans,c1+rec(i1+1,i2,s1,s2,c1,c2,dp));
            ans=Math.min(ans,c2+rec(i1,i2+1,s1,s2,c1,c2,dp));
        }
        return dp[i1][i2]=ans;
    }
    public int findMinCost(String s1, String s2, int c1, int c2) {
        // code here
        int dp[][]=new int[s1.length()][s2.length()];
        for(int i[]: dp)
        Arrays.fill(i,-1);
        return rec(0,0,s1,s2,c1,c2,dp);
    }
}