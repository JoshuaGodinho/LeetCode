class RandomizedCollection {
    private List<Integer> values;
    private Map<Integer,Set<Integer>> indexMap;
    private Random rand;

    public RandomizedCollection() {
        values=new ArrayList<>();
        indexMap=new HashMap<>();
        rand=new Random();    
    }
    
    public boolean insert(int val) {
        boolean isNew = !indexMap.containsKey(val);
        indexMap.putIfAbsent(val, new HashSet<>());
        indexMap.get(val).add(values.size());
        values.add(val);
        return isNew;
    }
    
    public boolean remove(int val) {
        if(!indexMap.containsKey(val) || indexMap.get(val).isEmpty())   return false;

        int indexToRemove=indexMap.get(val).iterator().next();
        indexMap.get(val).remove(indexToRemove);

        int lastIndex=values.size()-1;
        int lastVal=values.get(lastIndex);

        if(indexToRemove!=lastIndex)
        {
            values.set(indexToRemove, lastVal);
            indexMap.get(lastVal).remove(lastIndex);
            indexMap.get(lastVal).add(indexToRemove);
        }

        values.remove(lastIndex);

        if(indexMap.get(val).isEmpty())
            indexMap.remove(val);

        return true;
    }
    
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */