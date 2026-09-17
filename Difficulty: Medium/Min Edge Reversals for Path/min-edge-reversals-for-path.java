class Solution {
    static class Pair
    {
        int n;
        int d;
        Pair(int n,int d)
        {
            this.n=n;
            this.d=d;
        }
    }
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i[]: edges)
        {
            adj.get(i[0]-1).add(new Pair(i[1]-1,0));
            adj.get(i[1]-1).add(new Pair(i[0]-1,1));
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.d-b.d);
        int sp[]=new int[n];
        Arrays.fill(sp,-1);
        
        sp[src-1]=0;
        
        pq.add(new Pair(src-1,0));
        while(!pq.isEmpty())
        {
            Pair t=pq.poll();
            for(Pair i: adj.get(t.n))
            {
                if(sp[i.n]==-1 || sp[i.n]>sp[t.n]+i.d)
                {
                    sp[i.n]=sp[t.n]+i.d;
                    pq.add(new Pair(i.n,sp[i.n]));
                }
            }
        }
        return sp[dst-1];
    }
}