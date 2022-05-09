class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> totalAnagrams = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String unsorted: strs){
            char[] charArray = unsorted.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(unsorted);
        }
        totalAnagrams.addAll(map.values());        
        
        return totalAnagrams;
    }
}