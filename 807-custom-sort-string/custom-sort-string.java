class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map=new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb=new StringBuilder();

        for (char c : order.toCharArray()){
            if(map.containsKey(c)){
                int count=map.get(c);
                while(count-->0)
                    sb.append(c);
                map.remove(c);
            }
        }

         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count=entry.getValue();
            while(count-->0){
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}