class LFUCache {
    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> keyToVal;
    private final Map<Integer,Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyToVal.containsKey(key))
            return -1;

        int freq=keyToFreq.get(key);
        keyToFreq.put(key,freq+1);
        freqToKeys.get(freq).remove(key);

        if(!freqToKeys.containsKey(freq+1))
        {
            freqToKeys.put(freq+1,new LinkedHashSet<>());
        }
        freqToKeys.get(freq+1).add(key);

        if(freqToKeys.get(freq).isEmpty())
        {
            freqToKeys.remove(freq);
            if(minFreq==freq)
                minFreq++;
        }
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity==0)
            return;
        
        if(keyToVal.containsKey(key))
        {
            keyToVal.put(key,value);
            get(key);
            return;
        }
        if(keyToVal.size()>=capacity)
        {
            int evict=freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(evict);
            keyToVal.remove(evict);
            keyToFreq.remove(evict);
        }

        keyToVal.put(key,value);
        keyToFreq.put(key,1);
        minFreq=1;
        freqToKeys.computeIfAbsent(1,ignore->new LinkedHashSet<>()).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */