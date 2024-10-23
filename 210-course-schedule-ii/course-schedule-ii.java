class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> prereq=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            prereq.put(i,new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            prereq.get(pre[0]).add(pre[1]);
        }

        List<Integer> output=new ArrayList<>();
        HashSet<Integer> visited=new HashSet<>();
        HashSet<Integer> cycle=new HashSet<>();

        for(int c=0;c<numCourses;c++){
            if(!dfs(c,prereq,visited,cycle,output))
                return new int[0];
        }

        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            result[i]=output.get(i);

        return result;
        
    }

    private boolean dfs(int course, HashMap<Integer, List<Integer>> prereq,HashSet<Integer> visited, HashSet<Integer> cycle, List<Integer> output ){
        if(cycle.contains(course))
            return false;
        
        if(visited.contains(course))
            return true;

        cycle.add(course);

        for(int pre:prereq.get(course)){
            if(!dfs(pre,prereq,visited,cycle,output))
                return false;
        }

        cycle.remove(course);
        visited.add(course);
        output.add(course);

        return true;
    }
}