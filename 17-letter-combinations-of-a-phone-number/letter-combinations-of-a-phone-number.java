

class Solution {
    private static final String[] Keys={
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();

        if(digits==null || digits.length()==0)
            return result;  

        backtrack(result, digits, new StringBuilder(), 0);

        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index){
        if(index==digits.length()){
            result.add(current.toString());
            return;
        }

        String letters=Keys[digits.charAt(index)-'0'];

        for(char letter:letters.toCharArray()){
            current.append(letter);
            backtrack(result,digits,current,index+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}