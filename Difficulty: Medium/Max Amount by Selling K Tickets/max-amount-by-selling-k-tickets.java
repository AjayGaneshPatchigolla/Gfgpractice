class Solution {
    public int maxAmount(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> b-a);
        for(int i: arr)
        pq.add(i);
        int ans=0,mod=1000000007;
        while(k>0 && !pq.isEmpty())
        {
            int t=pq.poll();
            ans=(ans%mod+t%mod)%mod;
            if(t>0)
            pq.add(t-1);
            k-=1;
        }
        return ans;
    }
}