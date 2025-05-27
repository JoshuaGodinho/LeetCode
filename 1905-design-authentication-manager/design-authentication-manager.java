class AuthenticationManager {
    private Map<String, Integer> tokens;
    private final int timeToLive;
    public AuthenticationManager(int timeToLive) {
        this.tokens=new HashMap<>();
        this.timeToLive=timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime+timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(tokens.containsKey(tokenId) && currentTime<tokens.get(tokenId))
            tokens.put(tokenId, currentTime+timeToLive);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        List<String> expired=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:tokens.entrySet())
        {
            if(entry.getValue()<=currentTime)
            {
                expired.add(entry.getKey());
            }
        }

        for(String token: expired)
        {
            tokens.remove(token);
        }
        return tokens.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */