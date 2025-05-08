class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> valid=new HashSet<>(Arrays.asList(bank));
        if(!valid.contains(endGene))    return -1;

        Queue<String> queue=new LinkedList<>();
        queue.offer(startGene);

        Set<String> visited=new HashSet<>();
        visited.add(startGene);

        char[] genes={'A', 'C', 'G', 'T'};
        int steps=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            steps++;
            for(int i=0;i<size;i++){
                String current=queue.poll();

                for(int j=0;j<current.length();j++){
                    char[] arr=current.toCharArray();
                    for(char c:genes){
                        if(arr[j]==c)   continue;
                        arr[j]=c;
                        String next=new String(arr);

                        if(next.equals(endGene))    return steps;
                        if(valid.contains(next) && !visited.contains(next))
                        {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return -1;

    }
}