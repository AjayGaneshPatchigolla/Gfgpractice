

// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int cnt=0,i=0,j=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]<b[j])
            {
                cnt+=1;
                if(cnt==k)return a[i];
                i+=1;
            }
            else
            {
                cnt+=1;
                if(cnt==k)return b[j];
                j+=1;
            }
        }
        while(i<a.length)
        {
            cnt+=1;
            if(cnt==k)return a[i];
            i+=1;
        }
        while(j<b.length)
        {
            cnt+=1;
            if(cnt==k)return b[j];
            j+=1;
        }
        return -1;
    }
}