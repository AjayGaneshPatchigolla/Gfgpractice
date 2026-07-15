class Solution {
    public int bitonic(int[] arr) {
        // code here
        int ans=1,n=arr.length;
        int ltr[]=new int[n];
        int rtl[]=new int[n];
        ltr[0]=1;
        rtl[n-1]=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>=arr[i-1])
            {
                ltr[i]=ltr[i-1]+1;
            }
            else
            ltr[i]=1;
        }
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]>=arr[i+1])
            rtl[i]=rtl[i+1]+1;
            else
            rtl[i]=1;
        }
        // System.out.println(Arrays.toString(ltr));
        // System.out.println(Arrays.toString(rtl));
        for(int i=0;i<n-1;i++)
        ans=Math.max(ans,ltr[i]+rtl[i+1]);
        ans=Math.max(ans,Math.max(rtl[0],ltr[n-1]));
        return ans;
    }
}