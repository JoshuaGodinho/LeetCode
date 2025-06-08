
class Solution {
    public String findValidPair(String s) {
        int n=s.length();

        int[] freq=new int[10];

        for(int i=0;i<n;i++)
        {
            freq[s.charAt(i)-'0']++;
        }

        for(int i=0;i<n-1;i++)
        {
            char a=s.charAt(i);
            char b=s.charAt(i+1);

            if(a!=b && freq[a-'0']==a-'0' && freq[b-'0']==b-'0')
            {
                return ""+ a + b;
            }
        }

        return "";
    }
}