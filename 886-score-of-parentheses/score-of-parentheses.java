class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0);

        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                stack.push(0);
            }
            else
            {
                int last=stack.pop();
                int secondLast=stack.pop();
                stack.push(secondLast+Math.max(2*last,1));
            }
        }

        return stack.pop();
    }
}