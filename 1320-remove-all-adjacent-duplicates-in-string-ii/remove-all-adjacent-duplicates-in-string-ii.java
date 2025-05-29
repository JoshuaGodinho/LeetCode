/*
Input: s = "pbbcggttciiippooaais", k = 2
count of each adjacent alphabet

*/

class Solution {
    private static class Pair{
        char ch;
        int count;
        Pair(char ch, int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack=new Stack<>();

        for(char c:s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek().ch==c)
            {
                stack.peek().count++;
                if(stack.peek().count==k)
                {
                    stack.pop();
                }
            }else
            {
                stack.push(new Pair(c,1));
            }
        }

        StringBuilder sb=new StringBuilder();
        for(Pair p:stack)
        {
            for (int i = 0; i < p.count; i++)
            {
                 sb.append(p.ch);
            }
        }

        return sb.toString();
    }
}