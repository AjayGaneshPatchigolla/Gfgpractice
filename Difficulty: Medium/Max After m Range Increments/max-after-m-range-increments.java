class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // code here
        int tmp[]=new int[n+1];
        for(int i=0;i<a.length;i++)
        {
            tmp[a[i]]+=k[i];
            tmp[b[i]+1]-=k[i];
        }
        int ans=tmp[0];
        for(int i=1;i<=n;i++)
        {
            tmp[i]+=tmp[i-1];
            ans=Math.max(ans,tmp[i]);
        }
        return ans;
    }
}
