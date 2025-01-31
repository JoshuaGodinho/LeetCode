class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>(numCourses);

        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());

        for(int[] prerequisite: prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }

        int nodeVisited=0;

        while(!queue.isEmpty()){
            int node=queue.poll();
            nodeVisited++;

            for(int neighbour:adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                    queue.offer(neighbour);
            }
        }

        return nodeVisited==numCourses;
    }
}