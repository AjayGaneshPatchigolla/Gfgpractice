class Solution {
    public int maxIndexDifference(String s) {
        // code here
        char tc='a';
        int aind=-1,lvi=-1,ans=-1;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='a')
            {
                aind=i;
                lvi=i;
                break;
            }
        }
        if(lvi==-1)
        return -1;
        for(int i=lvi;i<s.length();i++)
        {
            char c=s.charAt(i),pc=(char)(c-1);
            // System.out.println(pc);
            if(pc==tc)
            {
                tc=c;
                lvi=i;
            }
            else if(c<=tc && c>'a')
            {
                lvi=i;
            }
        }
        // System.out.println(lvi+" "+aind);
        // if(tc=='a')
        // return 0;
        return lvi-aind;
    }
}