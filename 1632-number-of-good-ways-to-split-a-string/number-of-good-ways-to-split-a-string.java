class Solution {
    public int numSplits(String s) {
        
        int[] left=new int[26];
        int[] right=new int[26];
        int goodSplits=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            right[c-'a']++;
        }

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            left[c-'a']++;

            right[c-'a']--;

            if(getCount(left)==getCount(right))
                goodSplits++;
        }
        return goodSplits;
    }

    int getCount(int[] count)
    {
        int c=0;
        for(int i=0;i<count.length;i++)
        {
            if(count[i]!=0)
                c++;
        }
        return c;
    }
}