/*
/.../a/../b/c/../d/./

... a   ..  b   c   d   .
*/
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<String>();
        String[] components=path.split("/");

        for(String directory:components){
            if(directory.equals(".") || directory.isEmpty())
                continue;
            else if(directory.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.add(directory);
        }

        StringBuilder result=new StringBuilder();
        for(String directory: stack){
            result.append("/");
            result.append(directory);
        }        

        return result.length()>0 ? result.toString() : "/";
    }
}