class Solution {
    static class Pair
    {
        int x,d;
        Pair(int x,int d)
        {
            this.x=x;
            this.d=d;
        }
    }
    public int minThrows(int n, int[] lad, int[] sn) {
        // code here
        Comparator<Pair> custom=new Comparator<>(){
            public int compare(Pair a,Pair b)
            {
                if(a.d==b.d)
                return b.x-a.x;
                return a.d-b.d;
            }
        };
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<lad.length;i+=2)
        hm.put(lad[i],lad[i+1]);
        for(int i=0;i<sn.length;i+=2)
        hm.put(sn[i],sn[i+1]);
        PriorityQueue<Pair> pq=new PriorityQueue<>(custom);
        pq.add(new Pair(1,0));
        int v[]=new int[n*n+1];
        v[1]=1;
        while(!pq.isEmpty())
        {
            Pair t=pq.poll();
            if(t.x==n*n)return t.d;
            for(int i=6;i>=1;i--)
            {
                int nd=t.x+i;
                if(nd>n*n)continue;
                if(hm.containsKey(nd))
                nd=hm.get(nd);
                if(v[nd]==0)
                {
                    v[nd]=1;
                    pq.add(new Pair(nd,t.d+1));
                }
            }
        }
        return -1;
    }
}