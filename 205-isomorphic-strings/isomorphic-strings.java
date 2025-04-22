class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mappingDictToT=new int[256];
        Arrays.fill(mappingDictToT,-1);

        int[] mappingDictToS=new int[256];
        Arrays.fill(mappingDictToS,-1);

        for(int i=0;i<s.length();i++)
        {
            char c1=s.charAt(i);
            char c2=t.charAt(i);

            if(mappingDictToT[c1]==-1 && mappingDictToS[c2]==-1)
            {
                mappingDictToT[c1]=c2;
                mappingDictToS[c2]=c1;
            }
            else if(!(mappingDictToT[c1]==c2 && mappingDictToS[c2]==c1))
                return false;
        }

        return true;
    }
}