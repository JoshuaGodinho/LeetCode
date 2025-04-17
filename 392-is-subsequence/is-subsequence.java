class Solution {
    public boolean isSubsequence(String s, String t) {
        HashMap<Character, List<Integer>> letterIndicesTable=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            if(letterIndicesTable.containsKey(t.charAt(i)))
                letterIndicesTable.get(t.charAt(i)).add(i);
            else
            {
                ArrayList<Integer> indices=new ArrayList<>();
                indices.add(i);
                letterIndicesTable.put(t.charAt(i),indices);
            }
        }

        int currMatchIndex=-1;
        for(char letter:s.toCharArray())
        {
            if(!letterIndicesTable.containsKey(letter))
                return false;
            
            boolean matched=false;
            for(int matchIndex: letterIndicesTable.get(letter))
            {
                if(currMatchIndex<matchIndex)
                {
                    currMatchIndex=matchIndex;
                    matched=true;
                    break;
                }
            }
            if(!matched)
                return false;
        }

        return true;
    }
}