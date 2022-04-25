package ReconstructItinerary;

class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    LinkedList<String> result = new LinkedList<String>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets){
            if(!map.containsKey(ticket.get(0))){
                PriorityQueue<String> q = new PriorityQueue<String>();
                map.put(ticket.get(0), q);
            }
            map.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        dfs("JFK");
        return result;
        
    }
    
    public void dfs(String s){
        // First in, first out of the given Keys
        PriorityQueue<String> q = map.get(s);
        
        while(q != null && !q.isEmpty()){
            // Remove the HEAD and find the Destination
            dfs(q.poll());
        }
        
        result.addFirst(s);
    }
}