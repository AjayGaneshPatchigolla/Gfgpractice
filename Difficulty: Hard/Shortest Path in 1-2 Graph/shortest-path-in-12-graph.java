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
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        int sp[]=new int[V];
        Arrays.fill(sp,-1);
        sp[src]=0;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<>());
        for(int i[]: edges)
        {
            adj.get(i[0]).add(new Pair(i[1],i[2]));
            adj.get(i[1]).add(new Pair(i[0],i[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.w-b.w);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty())
        {
            Pair tmp=pq.poll();
            // System.out.println(tmp.n+" "+tmp.w);
            if(tmp.n==dest)
            return tmp.w;
            for(Pair i: adj.get(tmp.n))
            {
                if(sp[i.n]==-1 || sp[tmp.n]+i.w<sp[i.n])
                {
                    sp[i.n]=i.w+sp[tmp.n];
                    pq.add(new Pair(i.n,sp[i.n]));
                }
            }
        }
        return -1;
    }
}