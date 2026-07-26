class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> tmp=new ArrayList<>();
        int cnt=0,ps=1;
        for(int i=0;i<arr.length;i++)
        {
            tmp.add(arr[i]);
            cnt+=1;
            if(ps==cnt)
            {
                ps*=2;
                cnt=0;
                Collections.sort(tmp);
                ans.add(tmp);
                tmp=new ArrayList<>();
            }
        }
        if(cnt>0){
            Collections.sort(tmp);
            ans.add(tmp);
        }
        return ans;
    }
}