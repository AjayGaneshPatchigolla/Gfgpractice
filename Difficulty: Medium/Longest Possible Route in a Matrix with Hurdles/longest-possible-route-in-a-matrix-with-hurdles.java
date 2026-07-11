class Solution {
    static int rec(int xs,int ys,int xd,int yd,int vis[][],int mat[][])
    {
        // System.out.println(xs+" "+ys);
        // vis[xs][xd]=1;
        if(xs==xd && ys==yd)
        return 0;
        int ans=Integer.MIN_VALUE;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        for(int k=0;k<4;k++)
        {
            int nx=dx[k]+xs;
            int ny=dy[k]+ys;
            if(nx>=0 && nx<vis.length && ny>=0 && ny<vis[0].length && vis[nx][ny]==0 && mat[nx][ny]==1)
            {
                vis[nx][ny]=1;
                ans=Math.max(ans,1+rec(nx,ny,xd,yd,vis,mat));
                vis[nx][ny]=0;
            }
        }
        // vis[xs][xd]=0;
        return ans;
    }
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // code here
        int r=mat.length,c=mat[0].length;
        int vis[][]=new int[r][c];
        vis[xs][ys]=1;
        int ans=rec(xs,ys,xd,yd,vis,mat);
        return (ans<0)?-1:ans;
    }
}