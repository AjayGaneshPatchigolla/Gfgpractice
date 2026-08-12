class Solution {
    static int mod=1000000007;
    static int rec(int i,int j,int grid[][],int r,int c,int dp1[][])
    {
        if(i==(r-1) && (j==c-1))
        return 1;
        if(dp1[i][j]!=-1)
        return dp1[i][j];
        int ans=0;
        if(grid[i][j]==1)
        {
            if((j+1)<c)
            ans=(ans%mod+rec(i,j+1,grid,r,c,dp1)%mod)%mod;
        }
        else if(grid[i][j]==2)
        {
            if((i+1)<r)
            ans=(ans%mod+rec(i+1,j,grid,r,c,dp1)%mod)%mod;
        }
        else
        {
            if((i+1)<r)
            ans=(ans%mod+rec(i+1,j,grid,r,c,dp1)%mod)%mod;
            if((j+1)<c)
            ans=(ans%mod+rec(i,j+1,grid,r,c,dp1)%mod)%mod;
        }
        return dp1[i][j]=ans;
    }
    static int rec1(int i,int j,int grid[][],int r,int c,int dp2[][])
    {
        // System.out.println(i+" "+j);
        if(i==(r-1) && j==(c-1))
        return grid[i][j];
        if(dp2[i][j]!=-1)
        return dp2[i][j];
        int ans=0;
        if(grid[i][j]==1)
        {
            if((j+1)<c){
                int val=rec1(i,j+1,grid,r,c,dp2);
                if(val>0)
                ans=Math.max(ans,1+val);
            }
        }
        else if(grid[i][j]==2)
        {
            if((i+1)<r){
            int val=rec1(i+1,j,grid,r,c,dp2);
            if(val>0)
                ans=Math.max(ans,2+val);
            }
        }
        else
        {
            if((i+1)<r)
            {
                int val=rec1(i+1,j,grid,r,c,dp2);
                if(val>0)
                ans=Math.max(ans,3+val);
            }
            if((j+1)<c)
            {
                int val=rec1(i,j+1,grid,r,c,dp2);
                if(val>0)
                ans=Math.max(ans,3+val);
            }
        }
        return dp2[i][j]=ans;
    }
    public ArrayList<Integer> findWays(int[][] grid) {
        // Code here
        int n=grid.length;
        int dp1[][]=new int[n][n];
        int dp2[][]=new int[n][n];
        for(int i[]: dp1)
        Arrays.fill(i,-1);
        for(int i[]: dp2)
        Arrays.fill(i,-1);
        int paths=rec(0,0,grid,n,n,dp1);
        int maxPath=rec1(0,0,grid,n,n,dp2);
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(paths);
        ans.add(maxPath);
        return ans;
    }
}