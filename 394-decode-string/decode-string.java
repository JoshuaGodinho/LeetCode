class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack=new Stack<>();
        Stack<StringBuilder> stringStack=new Stack<>();

        StringBuilder current=new StringBuilder();
        int num=0;

        for(char c: s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                num=num*10+(c-'0');
            }
            else if(c=='[')
            {
                numStack.push(num);
                stringStack.push(current);
                current=new StringBuilder();
                num=0;
            }else if(c==']')
            {
                int repeat=numStack.pop();
                StringBuilder prev=stringStack.pop();
                for(int i=0;i<repeat;i++)
                {
                    prev.append(current);
                }
                current=prev;
            }else
            {
                current.append(c);
            }
        }

        return current.toString();
    }
}