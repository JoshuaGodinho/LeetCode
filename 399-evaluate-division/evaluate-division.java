class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph=new HashMap<>();

        for(int i=0;i<equations.size();i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            double val=values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b,new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a,1.0/val);
        }

        double[] result=new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String src=queries.get(i).get(0);
            String dest=queries.get(i).get(1);

            Set<String> visited=new HashSet<>();
            double res=dfs(graph, src,dest,1.0,visited);
            result[i]=res;
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String src, String dest, double product, Set<String> visited){
        if(!graph.containsKey(src) || !graph.containsKey(dest)){
            return -1.0;
        }

        if(src.equals(dest)){
            return product;
        }

        visited.add(src);

        for(Map.Entry<String, Double> neighbor:graph.get(src).entrySet()){
            String nextNode=neighbor.getKey();
            if(visited.contains(nextNode))
                continue;

            double res=dfs(graph, nextNode, dest, product*neighbor.getValue(), visited);
            if(res!=-1.0)   return res;

        }

        return -1.0;
    }
}