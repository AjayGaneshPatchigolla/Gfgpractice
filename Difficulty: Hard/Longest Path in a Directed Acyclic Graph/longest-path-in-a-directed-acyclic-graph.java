class Solution {
    static class Pair
    {
        int n,w;
        Pair(int n,int w)
        {
            this.n=n;
            this.w=w;
        }
    }
    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        // code here
        int lp[]=new int[V];
        Arrays.fill(lp,Integer.MIN_VALUE);
        lp[src]=0;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        for(ArrayList<Integer> i: edges)
        {
            adj.get(i.get(0)).add(new Pair(i.get(1),i.get(2)));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> b.w-a.w);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty())
        {
            Pair t=pq.poll();
            for(Pair i: adj.get(t.n))
            {
                if(lp[i.n]<lp[t.n]+i.w)
                {
                    lp[i.n]=lp[t.n]+i.w;
                    pq.add(new Pair(i.n,t.n+i.w));
                }
            }
        }
        return lp;
    }
}
