class Solution {
    public int lowerbound(ArrayList<Integer> ar,int val)
    {
        int ind=Collections.binarySearch(ar,val);
        if(ind<0)
        {
            ind=-(ind+1);
            return ind;
        }
        while(ind>0 && ar.get(ind)==ar.get(ind-1))
        {
            ind-=1;
        }
        return ind;
    }
    public int minDeletions(int[] arr) {
        // code here
        int n=arr.length;
        ArrayList<Integer> ar=new ArrayList<>();
        ar.add(arr[0]);
        int cnt=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>ar.get(cnt-1)){
            ar.add(arr[i]);
            cnt+=1;
            }
            else
            {
                int ind=lowerbound(ar,arr[i]);
                ar.set(ind,arr[i]);
            }
        }
        // System.out.println(ar);
        return n-cnt;
    }
}