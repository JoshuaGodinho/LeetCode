class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        Boolean isPresent = false;

         for (String currWord : wordList) {   
            if (endWord.equals(currWord)) {
                isPresent = true;
                break; // If found, break out of the loop.
            }
        }
        if(!isPresent)
            return 0;
            
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);

        int distance=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            distance++;

            while(size--!=0){
                String currentWord=queue.poll();

                for(int i=0;i<currentWord.length();i++){
                    char[] tempWord=currentWord.toCharArray();

                    for(char j='a';j<='z';j++){
                        tempWord[i]=j;

                        String newWord=new String(tempWord);

                        if(newWord.equals(endWord))
                            return distance+1;
                        
                        if(wordSet.contains(newWord)){
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }

                    }
                }
            }
        }

        return 0;
    }
}